package com.example.leet_code_camp.LinkedList;


import java.util.HashMap;

public class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;

        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = this.map.get(key);
        remove(node); // remove from current position
        insertToFront(node); // move to front (most recently used)

        return node.value;
    }

    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // ✅ Update the value
            remove(node);       // ✅ Remove from current position
            insertToFront(node); // ✅ Re-insert at front
        } else {
            if (this.map.size() >= this.capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            insertToFront(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.next = this.head.next;
        node.prev = this.head;

        this.head.next.prev = node;
        this.head.next = node;
    }
}
