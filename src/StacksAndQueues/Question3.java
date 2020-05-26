package StacksAndQueues;

import LinkedLists.ListNode;

import java.util.ArrayList;

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
            System.err.println("Error: Empty stack.");
        }
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
}

public class Question3 {
    public static void main(String[] args) {
        int[] elem = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        SetOfStacks setOfStacks = new SetOfStacks();
        for(int i: elem){
            setOfStacks.push(i);
        }
        setOfStacks.printStacks();
    }
}
