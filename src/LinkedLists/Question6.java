package LinkedLists;

import java.util.Stack;

public class Question6 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1,2,5,2,1});
        boolean isPallindrome = checkIsPallindromeWithStack(head);
        System.out.println("Stack: "+isPallindrome);
//        isPallindrome = checkIsPallindromeWithRecursion(head);
    }

    private static boolean checkIsPallindromeWithStack(ListNode head) {
        Stack<Integer> pallindromCheck = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            pallindromCheck.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null && !pallindromCheck.isEmpty()){
            if(temp.val == pallindromCheck.pop()){
                temp = temp.next;
            }
            else
                return false;
        }
        return pallindromCheck.isEmpty() && temp == null;
    }
}
