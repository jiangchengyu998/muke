package com.offer.p3;

public class Three {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        head = listNode1;
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        printNode(head);
        System.out.println("----");
        deleteNode(head, listNode1);
        printNode(listNode1);

    }

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void deleteNode(ListNode head, ListNode deletedNode) {
        if (head == null || deletedNode == null) return;

        // 要删除的节点不是尾节点
        if (deletedNode.next != null) {
            ListNode dNext = deletedNode.next;
            deletedNode.value = dNext.value;
            deletedNode.next = dNext.next;
        } else if (head == deletedNode) {
            head = null;
        } else {
            ListNode pNode = head;
            while (pNode.next != deletedNode) {
                pNode = pNode.next;
            }
            pNode.next = null;
        }
    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
