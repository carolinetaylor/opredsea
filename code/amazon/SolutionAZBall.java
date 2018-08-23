package com.amazon;

import java.util.Stack;

/**
 * Created by Tian on 2017/4/7.
 */
public class SolutionAZBall {

    public static void main(String[] args) {
        SolutionAZBall azball = new SolutionAZBall();
        String[] score = {"5", "-2", "4", "Z", "X", "9", "+", "+"};
        System.out.println(azball.ballCount(score));
    }

    public int ballCount(String[] score) {
        if (score == null || score.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            String block = score[i];
            System.out.println(block);
            int val = 0;
            if (!stack.isEmpty() && block.equals("Z")) {
                val = stack.pop();
                sum -= val;
            } else if (!stack.isEmpty() && block.equals("X")) {
                val = stack.peek() * 2;
                sum += val;
                stack.push(val);
            } else if (block.equals("+")) {
                int size = stack.size();
                if (size >= 2) {
                    val = stack.get(size - 1) + stack.get(size - 2);
                } else if (size == 1) {//?????
                    val = stack.get(size - 1);
                }
                sum += val;
                stack.push(val);
            } else {
                val = Integer.parseInt(block);
                sum += val;
                stack.push(val);
            }
            System.out.println("sum: " + sum + stack);
        }
        System.out.println(sum);
        return sum;
    }
}
