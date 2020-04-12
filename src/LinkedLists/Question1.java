package LinkedLists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Question1 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1,1,4,2,3});
        head = removeDuplicates(head);
        ListNode.printList(head);
    }

    private static ListNode removeDuplicates(ListNode head) {
        HashSet<Integer> frequency = new HashSet<>();
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            if(frequency.contains(temp.val))
                prev.next = temp.next;
            else{
                frequency.add(temp.val);
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
