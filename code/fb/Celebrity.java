package com.fb;

/**
 * Created by Tian on 2017/4/30.
 */
public class Celebrity {
    public int findCelebrity(int n) {
        //first find the candidate
        int candidate = 0;

        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) candidate = i; //update candidate
        }

        //validate the candidate is real celebrity
        for (int i = 0; i < n; i++) {
            if ((candidate != i && knows(candidate, i)) || !knows(i, candidate)) return -1;
        }

        return candidate;
    }

    boolean knows(int a, int b) {
        return true;
    }
}
