package com.mianjing;

import java.util.HashSet;

/**
 * Created by Tian on 2017/3/15.
 */
public class SolutionStrstr {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        // Write your code here
        // the fundemental way is to create a hash for each substr and compare
        // the hash value.
        // in this practice we just utilize hashset
        if (target == null) {
            return -1;
        }

        HashSet<String> hash = new HashSet();
        hash.add(target);
        System.out.println(target);

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            char[] subStr = new char[target.length()];
            for (int j = 0; j < target.length(); j++) {
                subStr[j] = source.charAt(i + j);
            }
            String tmp = new String(subStr);
            if (hash.contains(tmp)) {
                return i;
            }
        }

        return -1;
    }
}
