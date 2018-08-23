package com.mianjing;

/**
 * Created by Tian on 2017/4/25.
 */
public class SolutionRegularE {
    public static void main(String[] args) {
        SolutionRegularE sre = new SolutionRegularE();
        sre.isMatch("aa", "a*");
    }

    boolean isMatch(String s, String p) {
        // write your code here
        //dp or recursion
        //try dp
        //dp[i][j] s[0-i]s[0-j] match true
        //p[j - 1] != *
        // dp[i-1][j-1] && s[i] == p[j] || p[j] == '.'
        //p[j - 1] == *
        // dp[i][j-2] ||
        //            (s[i - 1] == p[j - 2] || p[j - 2] == "." && dp[i - 1][j])

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] ||
                            (i > 0 &&
                                    (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') &&
                                    dp[i-1][j]);
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] &&
                            (s.charAt(i - 1) == p.charAt(j - 1) ||
                                    p.charAt(j - 1) == '.');
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[m][n] + ",");
            }
            System.out.println("\n");
        }
        return dp[m][n];
    }
}
