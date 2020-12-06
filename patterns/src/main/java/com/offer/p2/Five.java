package com.offer.p2;

import java.util.Stack;

public class Five {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = null;
        Node node2 = new Node(2);
        node2.next = node1;
        Node node3 = new Node(3);
        node3.next = node2;
        Node node4 = new Node(4);
        node4.next = node3;
        Node node5 = new Node(5);
        node5.next = node4;
        printNodeReversing(node5);
        System.out.println("+++++++");
        printNodeReversingReversing(node5);
    }

    public static void printNodeReversing(Node pNode) {
        Stack<Integer> stack = new Stack<>();
        while (pNode != null) {
            stack.push(pNode.getValue());
            pNode = pNode.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void printNodeReversingReversing(Node pNode) {
        if (pNode != null) {
            if (pNode.next != null) {
                printNodeReversingReversing(pNode.next);
            }
            System.out.println(pNode.getValue());
        }
    }

    static class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }
}
