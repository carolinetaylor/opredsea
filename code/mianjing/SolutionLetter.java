package com.mianjing;

import java.util.ArrayList;
import java.util.HashMap;

public class SolutionLetter {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        /* this is a dfs, combination from abc and def (2, 3)
           put abc to 2 and def to 3 as a hashtable
         */
        ArrayList<String> results = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return results;
        }

        HashMap<Character, String> hash = new HashMap<Character, String>();
        hash.put('0', "");
        hash.put('1', "");
        hash.put('2', "abc");
        hash.put('3', "def");
        hash.put('4', "ghi");
        hash.put('5', "jkl");
        hash.put('6', "mno");
        hash.put('7', "pqrs");
        hash.put('8', "tuv");
        hash.put('9', "wxyz");

        helper(digits, 0, new StringBuffer(), hash, results);
        System.out.println(results);
        return results;
    }

    private void helper(String digits, int index, StringBuffer combine,
                        HashMap<Character, String> hash, ArrayList<String> results) {

        if (index == digits.length()) {
            results.add(combine.toString());
            return;
        }

        System.out.println("index:" + index + digits.charAt(index));
        for (char c : hash.get(digits.charAt(index)).toCharArray()) {
            combine.append(c);
            helper(digits, index + 1, combine, hash, results);
            combine.deleteCharAt(combine.length() - 1);
        }
    }
}