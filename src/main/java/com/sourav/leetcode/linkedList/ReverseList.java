package com.sourav.leetcode.linkedList;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode next = reverseList(head.next);
        if(next == null){
            return head;
        }
        next.next = head;
        return next;
    }
}
