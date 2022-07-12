package com.sourav.leetcode.linkedList;

public class SumOfTwoLinkedLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode root = res;
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = (l1.val + l2.val + carry);
            carry = sum/10;
            sum = sum%10;
            res.next = new ListNode(sum);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            sum = (l1.val + carry);
            carry = sum/10;
            sum = sum%10;
            res.next = new ListNode(sum);
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null){
            sum = (l2.val + carry);
            carry = sum/10;
            sum = sum%10;
            res.next = new ListNode(sum);
            res = res.next;
            l2 = l2.next;
        }
        if (carry > 0){
            res.next = new ListNode(carry);
        }
        return root.next;
    }
}
