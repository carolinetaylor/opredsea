package com.mianjing;

/**
 * Created by Tian on 2017/3/25.
 */
public class SolutionCoins {
    public int count(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i - 2 >= 0 && dp[i - 2] != Integer.MAX_VALUE && dp[i - 2] + 1 < dp[i])
                dp[i] = dp[i - 2] + 1;
            System.out.println("1 dp["+i+"]=" + dp[i]);

            if (i - 5 >= 0 && dp[i - 5] != Integer.MAX_VALUE && dp[i - 5] + 1 < dp[i])
                dp[i] = dp[i - 5] + 1;
            System.out.println("2 dp["+i+"]=" + dp[i]);

            if (i - 7 >= 0 && dp[i - 7] != Integer.MAX_VALUE && dp[i - 7] + 1 < dp[i])
                dp[i] = dp[i - 7] + 1;

            System.out.println("3 dp["+i+"]=" + dp[i]);

        }

        System.out.println(dp[n]);
        return dp[n];
    }
}
