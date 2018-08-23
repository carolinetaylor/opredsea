package com.mianjing;

/**
 * Created by Tian on 2017/3/16.
 */
public class SolutionDP1 {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */


    public int longestIncreasingSubsequence(int[] nums) {
        int []f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    System.out.println("f" + i + "=" + f[i]);
                            f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                    System.out.println("f" + i + "=" + f[i] + "\tf" + j + "=" + f[j] + "\tj+1=" +(f[j] + 1));
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}
