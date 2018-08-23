package com.microsoft;

/**
 * Created by Tian on 2017/8/29.
 */
public class BestStock {
    public static void main(String[] args) {
        int[] prices = {60, 65, 67, 62, 61, 50, 70};
        int[] prices2 = {60, 65, 67, 62, 61, 50};
        int[] prices3 = {60, 60, 60, 60, 50, 51};

        BestStock bs = new BestStock();
        int[] a = bs.bestSell(prices2);
        System.out.println(a[0] +","+ a[1]);
    }

    int[] bestSell(int[] prices) {
        int[] res = new int[2];
        if (prices == null || prices.length < 2) return res;

        int min = prices[0];
        int profit = 0;
        int minindex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minindex = i;
            }
            if (profit < prices[i] - min) {
                profit = prices[i] - min;
                res[0] = minindex;
                res[1] = i;
            }
        }

        return res;
    }
}
