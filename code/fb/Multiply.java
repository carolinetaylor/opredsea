package com.fb;

/**
 * Created by Tian on 2017/5/14.
 */
public class Multiply {

    public static void main(String[] args) {
        Multiply mt = new Multiply();
        mt.multiply("123", "45");
    }

    public String multiply(String num1, String num2) {
        // Write your code here
        // 3 steps, count into result array
        // count carrier
        // trim top 0s
        int m = num1.length();
        int n = num2.length();
        int k = m + n;
        int[] res = new int[k];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                res[i + j + 1] +=
                        (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int a : res) {
            System.out.print(a+",");
        }
        int carrier = 0;
        for (int i = k - 1; i >= 0; i--) {
            int sum = res[i] + carrier;
            res[i] = sum % 10;
            carrier = sum / 10;
        }

//        for (int a : res) {
//            System.out.print(a+",");
//        }

        StringBuffer sb = new StringBuffer();
        for (int p : res) {
            System.out.println(p);
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        System.out.println(sb.toString());
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
