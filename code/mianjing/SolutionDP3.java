package com.mianjing;

/**
 * Created by Tian on 2017/3/20.
 */
public class SolutionDP3 {
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        // simple solution, use presum
        // i from 0 to n, if i < k, just count the presum
        // if i >=k, count the real sum by presum[i] - presum [i - k]
        // i = 5, k = 3, count from i - k (2) to i (5)
        // record the max

        double[] presum = new double[nums.length];

        presum[0] = nums[0];
        double maxsum = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i];
            System.out.println("presum " + i + "=" + presum[i]);
            if (i >= k) {
                maxsum = Math.max(maxsum, presum[i] - presum[i - k]);
                System.out.println("maxsum =" + maxsum);
            }
        }

        return maxsum / k;
    }
}
