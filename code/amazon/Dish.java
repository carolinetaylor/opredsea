package com.amazon;

import java.util.*;

/**
 * Created by Tian on 2017/8/8.
 */
public class Dish {
    public static void main(String[] args) {
        String[][] menu = {{"Pizza", "Italian"}, {"Pasta", "Italian"}, {"Burger", "American"}};
        String[][] person = {{"Peter", "Italian"}, {"Adam", "American"}, {"YiChi", "Chinese"},
                {"Me", "*"}};

        Dish dh = new Dish();
        String[][] res = dh.recommend(menu, person);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }
    }

    public String[][] recommend(String[][] menu, String[][] person) {
        int mx = menu.length;
        int my = menu[0].length;

        Map<String, Set<String>> menuHash = new HashMap<String, Set<String>>();
        for (int i = 0; i < menu.length; i++) {
            if (!menuHash.containsKey(menu[i][1])) {
                Set<String> set = new HashSet<String>();
                set.add(menu[i][0]);
                menuHash.put(menu[i][1], set);
            } else {
                menuHash.get(menu[i][1]).add(menu[i][0]);
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 0; i < person.length; i++) {
            if (person[i][1].equals("*")) {
                for (Set<String> set : menuHash.values()) {
                    for (String each : set) {
                        List<String> elem = new ArrayList<String>();
                        elem.add(person[i][0]);
                        elem.add(each);
                        res.add(elem);
                    }
                }
                continue;
            }
            if (!menuHash.containsKey(person[i][1])) continue;
            Set<String> set = menuHash.get(person[i][1]);
            for (String each : set) {
                List<String> elem = new ArrayList<String>();
                elem.add(person[i][0]);
                elem.add(each);
                res.add(elem);
            }
        }

        int n = res.size();
        String[][] ret = new String[n][2];
        for (int i = 0; i < n; i++) {
            ret[i][0] = res.get(i).get(0);
            ret[i][1] = res.get(i).get(1);
        }

        return ret;
    }
}

