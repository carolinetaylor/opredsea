package com.fb;

class Node {
    int data;
    Node left, right;
    Node (int data) {
        this.data = data;
        left = right = null;
    }
}

/**
 * Created by Tian on 2017/4/22.
 */
public class SolutionDoublyLinked {
    Node prev = null;
    Node head = null;

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.right = new Node(4);

        SolutionDoublyLinked sb = new SolutionDoublyLinked();

        sb.inOrder(n);

        sb.dblHelper(n);
        Node head = sb.head;
        while (head != null) {
            System.out.print(head.data + ",");
            head = head.right;
        }
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + ",");
        inOrder(root.right);
    }


    private void dblHelper(Node root) {
        if (root == null) {
            return;
        }

        dblHelper(root.left);

        if (prev == null) {
            head = root;
        } else {//connect root to prev
            root.left = prev;
            prev.right = root;
        }

        //save the right
        Node right = root.right;

        // circular link with head
        head.left = root;
        root.right = head;

        prev = root;// for next traversal

        dblHelper(right);
    }
}
