package LinkedLists;

public class Question2 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{2,3,4,7,6,5});
        int k = 2;
        ListNode element = findkthLastElementIterative(head, k);
        System.out.println(element == null? "Wrong value of k": element.val);
        int idx = findkthLastElementRecursive(head, k);
    }

    private static int findkthLastElementRecursive(ListNode head, int k) {
        if(head == null){
            return 0;
        }
        int idx = findkthLastElementRecursive(head.next, k)+1;
        if(idx == k){
            System.out.println("With recursion "+head.val);
        }
        return idx;
    }

    private static ListNode findkthLastElementIterative(ListNode head, int k) {
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int idx = len-k;
        if(idx<0){
            return null;
        }
        temp = head;
        for(int i = 0; i < idx; i++){
            temp = temp.next;
        }
        return temp;
    }
}
