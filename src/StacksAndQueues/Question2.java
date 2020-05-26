package StacksAndQueues;

public class Question2 {
    public static void main(String[] args) {
        int[] elementsToPush = {5,4,3,2};
        for(int i : elementsToPush){
            Stack.push(i);
        }
        System.out.println("Min: "+Stack.min());
        Stack.pop();
        System.out.println("Min: "+Stack.min());
        Stack.push(1);
        System.out.println("Min: "+Stack.min());
        Stack.printStack();
    }
}
