package LinkedLists;

public class CreateLinkedList {
    public static void main(String args[]){
        ListNode head = ListNode.createList(new int[]{0, 1, 2});
        ListNode temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
