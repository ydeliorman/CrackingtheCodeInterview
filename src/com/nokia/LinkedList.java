package com.nokia;
/*
13.02.2021
created by yalind
*/

import java.util.List;

public class LinkedList {
    static class Node {
        int val;
        Node next;
        Node previous;

        public Node() {
        }

        Node(int val, Node next, Node previous) {
            this.val = val;
            this.next = next;
            this.previous = previous;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node temp = this;
            sb.append("[");
            while (temp != null) {
                sb.append(temp.val).append(", ");
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    Node head;

    LinkedList() {
        head = null;
    }

    LinkedList(List<Integer> list) {
        head = new Node(list.get(0), null, null);
        Node temp = head;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new Node(list.get(i), null, null);
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        sb.append("[");
        while (temp != null) {
            sb.append(temp.val).append(", ");
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
