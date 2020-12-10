package com.offer.p3;

public class Four {
    public static void main(String[] args) {
        ListNode head;
        ListNode listNode1 = new ListNode(1);
        head = listNode1;
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode4;
        printNode(head);
        System.out.println("----");
        deleteNode(head);
        printNode(listNode1);

    }

    public static void printNode(ListNode head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void deleteNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode preListNode = null;
        ListNode pNode = head;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext != null && pNext.value == pNode.value) {
                needDelete = true;
            }
            if (!needDelete) {
                preListNode = pNode;
                pNode = pNode.next;
            } else {
                int value = pNode.value;
                ListNode toBeDeleteNode = pNode;
                while (toBeDeleteNode != null && toBeDeleteNode.value == value) {
                    pNext = toBeDeleteNode.next;
                    toBeDeleteNode = pNext;
                }
                if (preListNode != null) {
                    preListNode.next = pNext;
                }
                pNode = pNext;
            }
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
