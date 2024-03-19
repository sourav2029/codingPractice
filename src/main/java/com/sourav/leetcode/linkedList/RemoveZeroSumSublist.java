package com.sourav.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumSublist {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode start = front;
        while (start != null) {
            int prefixSum = 0;
            ListNode end = start.next;
            while (end != null) {
                prefixSum += end.val;
                if (prefixSum == 0) {
                    start.next = end.next;
                }
                end = end.next;
            }
            start = start.next;
        }
        return front.next;
    }

    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode front = new ListNode(0, head);
        front.next = head;
        ListNode current = front;
        int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, front);

        while (current != null) {
            prefixSum += current.val;
            map.put(prefixSum, current);
            current = current.next;
        }

        prefixSum = 0;
        current = front;

        while (current != null) {
            prefixSum += current.val;
            current.next = map.get(prefixSum).next;
            current = current.next;
        }
        return front.next;
    }
}
