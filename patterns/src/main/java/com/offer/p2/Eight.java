package com.offer.p2;

import java.util.Stack;

public class Eight {

    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);

        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    static class Queue<T>{
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();
        public void appendTail(T element){
            stack1.push(element);
        }

        public T deleteHead() throws Exception {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                throw new Exception("queue is empty!");
            }
            return stack2.pop();
        }
    }
}
