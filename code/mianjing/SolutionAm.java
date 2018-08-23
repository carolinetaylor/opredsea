package com.mianjing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tian on 2017/4/5.
 */
public class SolutionAm {
    List<String> res;

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<String>();
        helper(num, target, "", 0, 0);
        return res;
    }

    private void helper(String num, int target, String tmp, long currRes, long prevNum) {
        //final result
        if (currRes == target && num.length() == 0) {
            System.out.println("currRes" + currRes + "target" + target);
            String exp = new String(tmp);
            res.add(exp);
            return;
        }

        //dfs all possibility
        for (int i = 1; i <= num.length(); i++) {
            String currStr = num.substring(0, i);
            //start from 0, return;
            if (currStr.length() > 1 && currStr.charAt(0) == '0')
                return;

            long currNum = Long.parseLong(currStr); //this is the current num
            String next = num.substring(i); //this is the next num
            if (tmp.length() != 0) {
                //multipication
                helper(next, target, tmp+"*"+currNum, (currRes - prevNum) + prevNum * currNum, prevNum * currNum);
                //addition
                helper(next, target, tmp+"+"+currNum, currRes + currNum, currNum);
                //substrication
                helper(next, target, tmp+"-"+currNum, currRes - currNum, currNum);
            } else {
                //the first one, no "-+*"
                helper(next, target, currStr, currNum, currNum);
            }
        }
    }
}
