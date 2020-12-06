package com.offer.p2;

public class Seven {

    public static void main(String[] args) {
        BinaryTreeNode h = new BinaryTreeNode("h");
        BinaryTreeNode i = new BinaryTreeNode("i");
        BinaryTreeNode e = new BinaryTreeNode("e");
        e.left = h;
        e.right = i;
        h.parent = e;
        i.parent = e;

        BinaryTreeNode d = new BinaryTreeNode("d");
        BinaryTreeNode b = new BinaryTreeNode("b");
        d.parent = b;
        b.left = d;
        b.right = e;
        e.parent = b;

        BinaryTreeNode c = new BinaryTreeNode("c");
        BinaryTreeNode f = new BinaryTreeNode("f");
        BinaryTreeNode g = new BinaryTreeNode("g");
        f.parent = c;
        g.parent = c;
        c.left = f;
        c.right = g;

        BinaryTreeNode a = new BinaryTreeNode("a");
        a.left = b;
        a.right = c;
        b.parent = a;
        c.parent = a;

        test(h, e);
        test(e, i);
        test(i, a);
        test(g, null);

//        PrintTree(a);

    }

    public static void test(BinaryTreeNode pNode, BinaryTreeNode expected){
        if (pNode == null) {
            System.out.println("输入错误");
        }
        if (expected == getNext(pNode)) {
            System.out.println("pass.");
        } else {
            System.out.println("failed!");
        }
    }

    public static BinaryTreeNode getNext(BinaryTreeNode pNode) {

        if (pNode == null) return null;
        BinaryTreeNode pNext = null;
        // 如果一个节点有右子树，那么他的下一个节点就是他的右子树中的最左子节点
        if (pNode.right != null) {
            BinaryTreeNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            pNext = pRight;
        }
        // 没有右子树
        else if (pNode.parent != null) {
            BinaryTreeNode pCurrent = pNode;
            BinaryTreeNode pParent = pNode.parent;
            // 且是右节点
            while (pParent!=null && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            pNext = pParent;
        }

        return pNext;
    }

    static class BinaryTreeNode{
        String value;
        BinaryTreeNode        left;
        BinaryTreeNode        right;
        BinaryTreeNode        parent;

        public BinaryTreeNode(String value) {
            this.value = value;
        }
    }

    public static void PrintTreeNode(BinaryTreeNode pNode)
    {
        if(pNode != null)
        {
            System.out.println("value of this node is:"+pNode.value);

            if(pNode.left != null)
                System.out.println("value of its left child is:"+pNode.left.value);
            else
                System.out.println("left child is null.");
            if(pNode.right != null)
                System.out.println("value of its right child is: " + pNode.right.value);
            else
                System.out.println("right child is null.");
        }
        else
        {
            System.out.println("this node is null.");
        }

        System.out.println("");
    }

    public static void PrintTree(BinaryTreeNode pRoot)
    {
        PrintTreeNode(pRoot);

        if(pRoot != null)
        {
            if(pRoot.left != null)
                PrintTree(pRoot.left);
            if(pRoot.right != null)
                PrintTree(pRoot.right);
        }
    }
}
