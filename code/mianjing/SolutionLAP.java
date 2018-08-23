package com.mianjing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tian on 2017/4/24.
 */
public class SolutionLAP {
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 5, 9, 7};
        SolutionLAP sl = new SolutionLAP();
        System.out.println(sl.maxLAP(nums));
    }

    public int maxLAP(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                if (map.containsKey(diff)) {
                    map.put(diff, map.get(diff) + 1);
                } else {
                    map.put(diff, 2);
                }
                if (map.get(diff) > max) {
                    max = map.get(diff);
                }
            }
        }

        return max;
    }
}
