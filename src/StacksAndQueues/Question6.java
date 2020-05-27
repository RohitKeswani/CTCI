package StacksAndQueues;

import java.util.Iterator;
import java.util.LinkedList;

class AnimalShelter{
    LinkedList<String> head = new LinkedList<>();

    public void enqueue(String s) {
        head.add(s);
    }

    public String dequeue(){
        return head.poll();
    }

    public boolean dequeueDog(){
        return head.removeFirstOccurrence("dog");
    }

    public boolean dequeueCat(){
        return head.removeFirstOccurrence("cat");
    }

    public void showAnimals(){
        Iterator itr = head.listIterator(0);
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
public class Question6 {
    public static void main(String[] args) {
        String[] elemToPush = {"dog", "cat", "dog", "cat"};
        AnimalShelter animalShelter = new AnimalShelter();
        for(String s: elemToPush){
            animalShelter.enqueue(s);
        }
        animalShelter.showAnimals();
        System.out.println("Dequeue Any: "+animalShelter.dequeue());
        System.out.println("Dequeue Dog: "+animalShelter.dequeueDog());
        System.out.println("Dequeue Cat: "+animalShelter.dequeueCat());
        animalShelter.showAnimals();
    }
}
