package StacksAndQueues;

import LinkedLists.ListNode;

import java.util.EmptyStackException;

class StackWithMin {
    static ListNode head = null;
    static int min = Integer.MAX_VALUE;

    public static void push(int val){
        ListNode node = ListNode.createNode(val);
        if (head != null) {
            node.next = head;
        }
        head = node;
        updateMin(val);
    }

    private static void updateMin(int val) {
        if(val<min){
            min = val;
        }
    }

    public static int pop(){
        int val;
        if(head!=null){
            val = head.val;
            head = head.next;
            checkAndUpdateMin(val);
            return val;
        }
        else {
            throw new EmptyStackException();
        }
    }

    private static void checkAndUpdateMin(int val) {
        if(val == min){
            min = Integer.MAX_VALUE;
            ListNode temp = head;
            while(temp!=null){
                if(temp.val<min){
                    min = temp.val;
                }
                temp = temp.next;
            }
        }
    }

    public static int peek(){
        if(head!=null){
            return head.val;
        }
        else{
            throw new EmptyStackException();
        }
    }

    public static int min(){
        if(min != Integer.MAX_VALUE)
            return min;
        else
            throw new EmptyStackException();
    }

    public static void printStack(){
        try{
            ListNode temp = head;
            System.out.print("TOP:"+temp.val);
            System.out.println();
            temp = temp.next;
            while(temp!=null){
                System.out.println("\t"+temp.val);
                temp = temp.next;
            }
            System.out.println();
        }
        catch(NullPointerException e) {
            System.err.println("Error: Empty stack.");
        }

    }
}

public class Question2 {
    public static void main(String[] args) {
        int[] elementsToPush = {5,4,3,2};
        for(int i : elementsToPush){
            StackWithMin.push(i);
        }
        System.out.println("Min: "+ StackWithMin.min());
        StackWithMin.pop();
        System.out.println("Min: "+ StackWithMin.min());
        StackWithMin.push(1);
        System.out.println("Min: "+ StackWithMin.min());
        StackWithMin.printStack();
    }
}
