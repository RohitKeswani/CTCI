package LinkedLists;

import java.util.Stack;

public class Question6 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1,2,5,2,1});
        boolean isPallindrome = checkIsPallindrome(head);
        System.out.println(isPallindrome);
    }

    private static boolean checkIsPallindrome(ListNode head) {
        int length = findLength(head);
        Stack<Integer> pallindromCheck = new Stack<>();
        int count = 0;
        while(count<length/2){
            pallindromCheck.push(head.val);
            head = head.next;
            count++;
        }
        if(length%2==1)
            head = head.next;
        while(!pallindromCheck.isEmpty() && head!=null){
            if(head.val==pallindromCheck.pop()){
                head = head.next;
            }
            else
                return false;
        }
        return pallindromCheck.isEmpty() && head == null;
    }

    private static int findLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}
