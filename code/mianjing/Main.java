package com.mianjing;
import com.amazon.SolutionBST;

import java.util.*;

/*
NewSort(["amber", "azure", "horse", "zebra", "buzz", "bazaar", "bar"], "zh")
     → ["zebra", "horse", "azure", "amber", "bazaar", "bar", "buzz"]

Results:    zebra,horse,azure,amber,bazaar,bar,buzz
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
//        ArrayList<String> test = new ArrayList<String>();
//        String[] input = {"amber", "azure", "horse", "zebra", "buzz", "bazaar", "bar"};
//        for (int i = 0; i < input.length; i++) {
//            test.add(input[i]);
//        }
//
//        new Main().newSort(test);
//
//        for (int i = 0; i < test.size(); i++) {
//            System.out.print(test.get(i) + ((i == test.size() - 1) ? " " : ","));
//        }

//        String a = "abcdef", b = "bcd";
//        SolutionStrstr ab = new SolutionStrstr();
//        System.out.println(ab.strStr2(a,b));

//        int[] nums = {4,2,4,3};
//        SolutionDP1 dp = new SolutionDP1();
//        dp.longestIncreasingSubsequence(nums);

//        SolutionDP2 dp2 = new SolutionDP2();
//        dp2.numSquares(13);
//        SolutionDP3 dp3 = new SolutionDP3();
//        int[] nums = {-2147483648,-2147483648,-2147483648,-2147483648};
//        System.out.println(dp3.maxAverage(nums, 2));

//        SolutionPla sp = new SolutionPla();
//        System.out.println(sp.longestPalindrome("babad"));

//        SolutionBFS1 bfs = new SolutionBFS1();
//        int[] a = {4,1,5,2,6,3};
//        int[][] b = {{5,2,6,3}, {4,1,5,2}};
//        bfs.sequenceReconstruction(a, b);

//        SolutionCoins co = new SolutionCoins();
//        co.count(27);

//        SolutionBreak1 bk = new SolutionBreak1();
//        Set<String> s = new HashSet<String>();
//        s.add("ab");
//        s.add("cde");
//        bk.wordBreak("abcdef", s);

//        SolutionLetter sl = new SolutionLetter();
//        sl.letterCombinations("3");

//        SolutionDeque dq = new SolutionDeque();
//        int[] nums = {4,2,1,4,3,6,7,8,8,8,1};
//        System.out.println(dq.maxSlidingWindow(nums, 3));

//        SolutionAm sa = new SolutionAm();
//        System.out.println(sa.addOperators("3456237490", 9191));

//        SolutionSort1 ss = new SolutionSort1();
//        int[] a = {1,3,1,6,1,9};
//        ss.countingSort(a);

//        SolutionAZBall ab = new SolutionAZBall();
//        String[] a = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
//        ab.ballCount(a);

        SolutionBST bst = new SolutionBST();
        int[] nums = {9, 7, 5, 3, 1};
        bst.findBST(nums, 7, 20);
    }


    public char[] dict = "zh".toCharArray();

    public void newSort(ArrayList<String> original) {
        Collections.sort(original, new NewCompare());
    }

    public class NewCompare implements Comparator<String> {

        public int compare(String a, String b) {
            int aindex = 0;
            int bindex = 0;

            while (aindex < a.length() && bindex < b.length()) {
                if (a.charAt(aindex) != b.charAt(bindex)) {
                    for (int i = 0; i < dict.length; i++) {
                        if (a.charAt(aindex) == dict[i] ) {
                            return -1; //a is 'smaller'
                        }
                        if (b.charAt(bindex) == dict[i]) {
                            return 1;//b is 'bigger'
                        }
                    }
                    return (a.charAt(bindex) - b.charAt(aindex));
                }
                aindex++;
                bindex++;
            }
            return b.length() - a.length();
        }
    }
}
