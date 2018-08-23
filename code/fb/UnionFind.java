package com.fb;

/**
 * Created by Tian on 2017/5/14.
 */
public class UnionFind {
    private int[] father = null;

    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;//init i's father is i
        }
    }

    public void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_b] = root_a; //a is b's father
        }

    }

    public int find(int x) {
        if (father[x] == x) { //father[x] is the root of index x
            return x;
        }
        //return father[x] = find(father[x]);// find next father
        return find(father[x]);// find next father
    }

    public void insight() {
        for (int i = 0; i < father.length; i++) {
            System.out.println("father:" + father[i] + "child(index)" + i);
        }
    }

    public static void main(String[] args) {
        UnionFind un = new UnionFind(10);
        un.union(4, 5);
        un.union(2, 4);
        un.union(0, 2);
        un.union(1, 6);
        un.insight();

        un.find(5);
        un.insight();
    }
}
