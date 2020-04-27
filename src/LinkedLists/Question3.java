package LinkedLists;

public class Question3 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{2,3,4,5});
        int k = 1;
        ListNode node = head;
        for(int i = 0; i<k; i++){
            node = node.next;
        }
        deleteNode(node);
        ListNode.printList(head);
    }

    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
