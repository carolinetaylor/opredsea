package com.mianjing;

/**
 * Created by Tian on 2017/3/21.
 */
public class SolutionPla {
    public String longestPalindrome(String s) {

        //given a string, find a position j, expand it to both left and right find palindrome
        // consider two different conditions, even abba or odd aba conditions
        if (s == null || s.length() < 1) {
            return null;
        }

        int max = 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            for (j = 0; i - j >= 0 && i + j < s.length(); j++) { //odd
                if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
                count = j * 2 + 1;
            }
            if (count > max) {
                max = count;
                index = i - (count - 1) / 2;
                System.out.println("a" + index + ":" + (i - j + 1));
                System.out.println("i" + i +"j" + j);
            }

            for (j = 0; i - j >= 0 && i + j + 1 < s.length(); j++) { //even
                if (s.charAt(i - j) != s.charAt(i + j + 1)) {
                    break;
                }
                count = j * 2 + 2;
            }
            if (count > max) {
                max = count;
                index = i - (count -2) / 2 ;
                System.out.println("b" + index + ":" + (i - j + 1));
                System.out.println("i" + i +"j" + j);
            }
        }

        return s.substring(index, index + max);
    }

    public static void main(String[] args) {
        SolutionPla pla = new SolutionPla();
        pla.longestPalindrome("cddb");
    }
}
