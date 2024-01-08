package com.sourav.leetcode.linkedList;

public class DeleteNode {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null){
            return null;
        }
        prev.next = slow.next;
        return head;
    }
}
