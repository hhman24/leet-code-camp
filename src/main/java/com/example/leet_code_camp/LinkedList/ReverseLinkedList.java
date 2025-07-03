package com.example.leet_code_camp.LinkedList;


public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;               // reverse current node's pointer
            prev = current;                    // move prev and current one step forward
            current = temp;
        }

        return prev;  // new head
    }


}
