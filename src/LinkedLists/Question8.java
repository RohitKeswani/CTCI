package LinkedLists;

import java.util.HashSet;

public class Question8 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1,2,3,4});
        ListNode loopNode = head;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = loopNode;
        ListNode checkedLoopNode = findLoopNodeRunner(head);
        System.out.println(checkedLoopNode.val);
        checkedLoopNode = findLoopNodeSet(head);
        System.out.println(checkedLoopNode.val);
    }

    private static ListNode findLoopNodeSet(ListNode head) {
        HashSet<ListNode> setOfNodes = new HashSet<>();
        while(!setOfNodes.contains(head)){
            setOfNodes.add(head);
            head = head.next;
        }
        return head;
    }

    private static ListNode findLoopNodeRunner(ListNode head) {
        ListNode slow = head, fast = head;
        do{
            slow = slow.next;
//            System.out.println(slow.val);
            fast = fast.next.next;
//            System.out.println(fast.val);
        } while(slow!=fast);
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
