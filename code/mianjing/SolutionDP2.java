package com.mianjing;

import java.util.Arrays;

/**
 * Created by Tian on 2017/3/16.
 */
public class SolutionDP2 {
    public int numSquares(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i) {
            dp[i * i] = 1;
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                System.out.print("dpi" + i + "=" + dp[i] + "\t -> \t");
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                System.out.println("dpi" + i + "=" + dp[i] + "\t ");
            }
        }

        return dp[n];
    }
}
