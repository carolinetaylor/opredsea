package com.amazon;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}

/**
 * Created by Tian on 2017/4/11.
 */
public class SolutionReverseList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // move to 1 -> m-1 > m -> n -> n+1 -> ... -> null
        // store the m-1->next and m->next
        // revert m -> n to n -> m
        // connect m-1 -> next to n
        // connect m->next to n+1

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            head = head.next;
        }

        ListNode m1 = head;
        ListNode m1next = head.next;

System.out.println(head.val);
System.out.println(head.next.val);

        head = head.next;

        ListNode prev = null;



        for (int i = m; i <= n; i++) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        m1next.next = head;
        m1.next = prev;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(5);
        reverseBetween(a, 2,3);
        while (a != null) {
            System.out.print(a.val);
            a = a.next;
        }
    }
}
