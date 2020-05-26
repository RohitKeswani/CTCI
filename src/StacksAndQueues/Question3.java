package StacksAndQueues;

import LinkedLists.ListNode;

import java.util.ArrayList;
import java.util.EmptyStackException;

class EachStack{
    int id;
    int currentSize;
    ListNode head;

    public EachStack(int id, int currentSize, ListNode head){
        this.id = id;
        this.currentSize = currentSize;
        this.head = head;
    }

    public boolean push(int val){
        if(currentSize<10){
            ListNode node = ListNode.createNode(val);
            if(head!=null){
                node.next = head;
            }
            head = node;
            currentSize++;
            return true;
        }
        else
            return false;
    }

    public void printStack(){
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
            e.printStackTrace();
        }
    }

    public int pop() {
        int val = head.val;
        head = head.next;
        return val;
    }

    public int peek() {
        return head.val;
    }
}

class SetOfStacks{
    int capacityOfEachStack = 10;
    ArrayList<EachStack> stackObjects = new ArrayList<>();
    int id = 0;

    public void push(int val){
        if(stackObjects.size()==0){
            EachStack stack = new EachStack(id, 0, null);
            stackObjects.add(stack);
            id++;
        }
        boolean isPushed = false;
        for (EachStack stackObject : stackObjects) {
            if (stackObject.currentSize < capacityOfEachStack) {
                isPushed = stackObject.push(val);
            }
        }
        if(!isPushed){
            EachStack stack = new EachStack(id, 0, null);
            stackObjects.add(stack);
            stack.push(val);
            id++;
        }
    }

    public void printStacks(){
        for(int i = stackObjects.size()-1; i>=0; i--){
            stackObjects.get(i).printStack();
        }
    }

    public int pop() {
        if(stackObjects.size()!=0){
            EachStack stack = stackObjects.get(stackObjects.size()-1);
            int val = stack.pop();
            if(stack.currentSize==1){
                stackObjects.remove(stackObjects.size()-1);
                id--;
            }
            return val;
        }
        else
            throw new EmptyStackException();
    }

    public int peek() {
        if(stackObjects.size()!=0){
            EachStack stack = stackObjects.get(stackObjects.size()-1);
            return stack.peek();
        }
        else
            throw new EmptyStackException();
    }
}

public class Question3 {
    public static void main(String[] args) {
        int[] elem = {1};
        SetOfStacks setOfStacks = new SetOfStacks();
        for(int i: elem){
            setOfStacks.push(i);
        }
        setOfStacks.printStacks();
        System.out.println(setOfStacks.pop());
        setOfStacks.push(11);
        System.out.println(setOfStacks.peek());
        setOfStacks.printStacks();
    }
}
