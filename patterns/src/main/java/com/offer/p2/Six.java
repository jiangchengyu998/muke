package com.offer.p2;

public class Six {

    public static void main(String[] args) {
//        int[] preOrder = {1,2,4,7,3,5,6,8};
//        int[] inOrder  = {4,7,2,1,5,3,8,6};
//        int[] preOrder = {1,2,4,5,3,6,8};
//        int[] inOrder  = {4,2,5,1,6,3,8};
        int[] preOrder = {1,2,3,4,5};
        int[] inOrder  = {5,4,3,2,1};
        BinaryTreeNode construct = construct(preOrder, inOrder, 8);
        System.out.println(construct);
        printNode(construct);
        System.out.println("+++++");
        printNode(myConstruct());
    }

    public static BinaryTreeNode myConstruct(){

        BinaryTreeNode e8 = new BinaryTreeNode(8);
        BinaryTreeNode e6 = new BinaryTreeNode(6);
        e6.left = e8;
        BinaryTreeNode e5 = new BinaryTreeNode(5);
        BinaryTreeNode e3 = new BinaryTreeNode(3);
        e3.left = e5;
        e3.right = e6;

        BinaryTreeNode e7 = new BinaryTreeNode(7);
        BinaryTreeNode e4 = new BinaryTreeNode(4);
        e4.right = e7;
        BinaryTreeNode e2 = new BinaryTreeNode(2);
        e2.left = e4;

        BinaryTreeNode e1 = new BinaryTreeNode(1);
        e1.right = e3;
        e1.left = e2;
        return e1;
    }

    public static void printNode(BinaryTreeNode node){
        if (node == null) return;
        System.out.print(node.getValue()+">");
        printNode(node.left);
        printNode(node.right);
    }

    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder, int length) {
        if (preOrder == null || inOrder == null
                || preOrder.length != inOrder.length
                || length <= 0){
            System.out.println("数据有误");
            return null;
        }
        return constructCore(preOrder, inOrder);
    }

    private static BinaryTreeNode constructCore(int[] preOrder, int[] inOrder) {
        // 前序遍历序列的第一个数字是根节点的值
        int rooValue = preOrder[0];
        BinaryTreeNode rootBinaryTreeNode = new BinaryTreeNode(rooValue);
        // 只有一个节点的情况下
        if (preOrder.length == inOrder.length && inOrder.length == 1) {
            return rootBinaryTreeNode;
        }

        // 在中序遍历中找到跟节点的值
        int rootValueIndex = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == rooValue) {
                rootValueIndex = i;
            }
        }

        int leftLength = rootValueIndex;
        int rightLength = inOrder.length - 1 - rootValueIndex;
        if (leftLength > 0) {
            int[] p = new int[leftLength];
            for (int i = 0; i < leftLength; i++) {
                p[i] = preOrder[i + 1];
            }
            int[] ints = new int[leftLength];
            for (int j = 0; j < leftLength; j++) {
                ints[j] = inOrder[j];
            }
            rootBinaryTreeNode.left = constructCore(p,ints);
        }
        if (rightLength > 0) {
            int[] p = new int[rightLength];
            for (int i = 0; i < rightLength; i++) {
                p[i] = preOrder[i + 1 + rootValueIndex];
            }
            int[] ints = new int[rightLength];
            for (int i = 0; i < rightLength; i++) {
                ints[i] = inOrder[rootValueIndex + 1];
            }

            rootBinaryTreeNode.right = constructCore(p,ints);
        }

        return rootBinaryTreeNode;
    }

    static class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "BinaryTreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

