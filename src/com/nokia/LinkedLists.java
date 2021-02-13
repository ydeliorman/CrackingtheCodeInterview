package com.nokia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LinkedLists {

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 20));
//        LinkedList linkedList = new LinkedList(list);

        //removeDups(linkedList.head);
        //System.out.println("removeDups :" + linkedList);

        //System.out.println("returnKthToLast :" + returnKthToLast(linkedList.head, 2));

        //deleteMiddleNode(linkedList.head.next.next);
        //System.out.println("deleteMiddleNode :" + linkedList);

        //System.out.println("partition :" +  partition(linkedList.head, 30));

        List<Integer> l1 = new ArrayList<>(Arrays.asList(7, 1, 6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(5, 9, 2));
        LinkedList list1 = new LinkedList(l1);
        LinkedList list2 = new LinkedList(l2);

        //System.out.println(sumList(list1.head, list2.head, 0));


//        List<Integer> l3 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1, 0));
//        LinkedList list3 = new LinkedList(l3);
//        System.out.println("palindrome :" + palindrome(list3.head));
//
//        System.out.println("intersection :" + intersection());
//
//        System.out.println("loopDetection :" + loopDetection());

    }

    private static void removeDups(LinkedList.Node n) {
        HashSet<Integer> occurenceMap = new HashSet<>();
        LinkedList.Node previous = null;

        while (n != null) {
            if (!occurenceMap.contains(n.val)) {
                occurenceMap.add(n.val);
                previous = n;
            } else {
                previous.next = n.next;
            }

            n = n.next;
        }
    }

    private static Integer returnKthToLast(LinkedList.Node n, int k) {
        if (n == null) {
            return 0;
        }

        int index = returnKthToLast(n.next, k) + 1;

        return index;
    }

    private static void deleteMiddleNode(LinkedList.Node n) {
        LinkedList.Node next = n.next;
        n.val = next.val;
        n.next = next.next;
    }

    private static LinkedList.Node partition(LinkedList.Node node, int x) {
        LinkedList.Node head = node;
        LinkedList.Node tail = node;

        while (node != null) {
            LinkedList.Node next = node.next;
            if (node.val < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;

        }

        tail.next = null;

        return head;

    }

    /*
    7 -> 1 -> 6
    5 -> 9 -> 2
     */
    //TODO FOLLOW UP BAK
    private static LinkedList.Node sumList(LinkedList.Node l1, LinkedList.Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedList.Node node = new LinkedList.Node();
        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
        }

        if (l2 != null) {
            sum += l2.val;
        }

        node.val = sum % 10;

        LinkedList.Node nextNode = sumList(l1.next, l2.next, sum / 10);
        node.next = nextNode;

        return node;
    }

    private static boolean palindrome(LinkedList.Node head) {
        LinkedList.Node reverseList = reverseList(head);
        while (head != null && reverseList != null) {
            if (head.val != reverseList.val) {
                return false;
            }

            head = head.next;
            reverseList = reverseList.next;
        }

        return true;
    }

    //TODO recursive bak
    private static LinkedList.Node reverseList(LinkedList.Node head) {
        LinkedList.Node prev = null;

        while (head != null) {
            LinkedList.Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static boolean intersection(LinkedList.Node l1, LinkedList.Node l2) {
        HashSet<LinkedList.Node> l1Set = new HashSet<>();

        while (l1 != null) {
            l1Set.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            if(l1Set.contains(l2)) {
                return false;
            }
            l2 = l2 .next;
        }

        return true;
    }

    private static LinkedList.Node loopDetection(LinkedList.Node head) {
        LinkedList.Node first = head;
        LinkedList.Node second = head;

        while (first != null && second != null) {
            first = first.next;
            second = second.next.next;
            if(first ==second) {
                return first;
            }
        }

        return  null;

    }
}
