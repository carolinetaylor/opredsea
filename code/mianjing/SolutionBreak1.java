package com.mianjing;

import java.util.Set;

/**
 * Created by Tian on 2017/3/25.
 */
public class SolutionBreak1 {
    public boolean wordBreak(String s, Set<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                System.out.println("out: j:" + j + "i:" + i + "word:" + word);
                if (dp[j] && wordDict.contains(word)) {
                    dp[i] = true;
                    System.out.println("in: j:" + j + "i:" + i + "word:" + word);
                    break;
                }
            }
        }

        for (int i = 0; i <=n; i++) {
            System.out.println(i + ":" + dp[i]);
        }
        return dp[n];
    }
}
