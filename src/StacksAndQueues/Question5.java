package StacksAndQueues;

import LinkedLists.ListNode;

import java.util.EmptyStackException;

class SortedStack{
    ListNode top = null;

    public void push(int i) {
        ListNode node = ListNode.createNode(i);
        if(top!=null){
            if(top.val>=node.val){
                node.next = top;
                top = node;
            }
            else{
                removeNodesTillEqualValue(node);
            }
        }
        else{
            top = node;
        }

    }

    private void removeNodesTillEqualValue(ListNode node) {
        ListNode temp = top;
        SortedStack stack = new SortedStack();
        while(temp!=null && temp.val<node.val){
            stack.push(this.pop());
            temp = temp.next;
        }
        node.next = temp;
        top = node;
        while(stack.top!=null){
            this.push(stack.pop());
        }
    }

    public void printStack() {
        try{
            ListNode temp = top;
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

    public int pop() {
        if(top!=null){
            int val = top.val;
            top = top.next;
            return val;
        }
        else
            throw new EmptyStackException();
    }
}
public class Question5 {
    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        int[] elemToPush = {1,2,5,4,3,8,6,5,8,10};
        for(int i: elemToPush){
            sortedStack.push(i);
        }
        sortedStack.printStack();
        System.out.println(sortedStack.pop());
        sortedStack.printStack();
    }
}
