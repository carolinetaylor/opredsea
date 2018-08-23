package com.amazon;

import java.util.*;

/**
 * Created by Tian on 2017/6/27.
 */

public class BuildTreeFromList {
    private static class TreeNode {
        int val;
        List<TreeNode> children;
        TreeNode parent;
        TreeNode(int val) {
            this.val = val;
            parent = null;
            children = new ArrayList<TreeNode>();
        }
    }

    public static void main(String[] args) {
        String[] paris = {"0,2", "1,2","0,1","0,3","3,4","4,5"};
        TreeNode root = buildTree(paris);
        System.out.println(root.val);
    }

    private static TreeNode buildTree(String[] pairs) {
        if (pairs == null || pairs.length == 0) {
            return null;
        }

        Map<Integer, TreeNode> hash = new HashMap<Integer, TreeNode>();
        for (String st : pairs) {
            String[] pair = st.split(",");
            //pair[0] = parent, pair[1] = child
            int parent = Integer.parseInt(pair[0]);
            int child = Integer.parseInt(pair[1]);
            if (!hash.containsKey(parent)) {
                hash.put(parent, new TreeNode(parent));
            }
            if (!hash.containsKey(child)) {
                hash.put(child, new TreeNode(child));
            }
            hash.get(parent).children.add(hash.get(child));
            hash.get(child).parent = hash.get(parent);
        }

        Iterator<TreeNode> it = hash.values().iterator();
        while (it.hasNext()) {
            TreeNode node = it.next();
            if (node.parent == null) {
                return node;
            }
        }

        return null;
    }
}
