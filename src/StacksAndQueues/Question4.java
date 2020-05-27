package StacksAndQueues;

import LinkedLists.ListNode;


class StackForQueue{
    ListNode top = null;

    public void push(int i) {
        ListNode node = ListNode.createNode(i);
        if(top!=null){
            node.next = top;
        }
        top = node;
    }

    public int pop() {
        if(top!=null){
            ListNode temp = top;
            StackForQueue stackForQueue = new StackForQueue();
            while(temp.next!=null){
                stackForQueue.push(temp.val);
                temp = temp.next;
            }
            int val = temp.val;
            top = null;
            temp = stackForQueue.top;
            while(temp!=null){
                this.push(temp.val);
                temp = temp.next;
            }
            return val;
        }
        else{
            throw new NullPointerException();
        }
    }

    public void printStack() {
        ListNode temp = top;
        StackForQueue stackForQueue = new StackForQueue();
        while(temp!=null){
            stackForQueue.push(temp.val);
            temp = temp.next;
        }
        temp = stackForQueue.top;
        while(temp!=null){
            if(temp.next==null){
                System.out.print(temp.val);
                temp = temp.next;
            }
            else{
                System.out.print(temp.val+"<--");
                temp = temp.next;
            }
        }
        System.out.println();
    }
}

class MyQueue{
    StackForQueue stack = new StackForQueue();

    public void enqueue(int i) {
        stack.push(i);
    }

    public int dequeue() {
        return stack.pop();
    }

    public void printQueue() {
        stack.printStack();
    }
}

public class Question4 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        int[] elemToPush = {1,2,3,4,5,6,7,8,9,10};
        for(int i : elemToPush){
            myQueue.enqueue(i);
        }
        myQueue.printQueue();
        System.out.println("Dequeued: "+myQueue.dequeue());
        System.out.println("Dequeued: "+myQueue.dequeue());
        myQueue.printQueue();
    }
}
