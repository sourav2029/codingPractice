package com.sourav.leetcode.linkedList;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return  prev;
    }

    public ListNode mergeList(ListNode head1 , ListNode head2){
        ListNode first = new ListNode(0);
        ListNode res = first;
        while(head1 != null || head2!= null){
            if(head1.val < head2.val){
                first.next = head1;
                head1 = head1.next;
            } else {
                first.next = head2;
                head2 = head2.next;
            }
            first = first.next;
        }
        while(head1!= null){
            first.next = head1;
            head1 = head1.next;
            first = first.next;
        }

        while (head2!= null){
            first.next = head2;
            head2 = head2.next;
            first = first.next;
        }
        return reverseList(res.next);
    }




}
