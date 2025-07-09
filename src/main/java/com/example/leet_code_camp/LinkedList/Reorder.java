package com.example.leet_code_camp.LinkedList;

public class Reorder {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // Step 3: Merge two halves
        ListNode first = head, secondHalf = prev;
        while (secondHalf != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = tmp1;

            first = tmp1;
            secondHalf = tmp2;
        }
    }
}
