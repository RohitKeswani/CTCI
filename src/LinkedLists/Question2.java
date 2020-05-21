package LinkedLists;

public class Question2 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1,2});
        int k = 2;
//        ListNode element = findkthLastElementIterative(head, k);
//        System.out.println(element == null? "Wrong value of k": element.val);
//        int idx = findkthLastElementRecursive(head, k);
        head = deleteNthLastNode(head, k);
        ListNode.printList(head);
    }

    private static ListNode deleteNthLastNode(ListNode head, int k) {
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int idx = len-k;
        if(idx==0){
            return head.next;
        }
        temp = head;
        ListNode prev = head;
        if(temp.next == null)
            return null;
        else
            temp = temp.next;
        for(int i = 1; i < len; i++){
            if(i!=idx){
                temp = temp.next;
                prev = prev.next;
            }
            else {
                if(temp.next == null){
                    prev.next = null;
                }
                else{
                    temp.val = temp.next.val;
                    temp.next = temp.next.next;
                }
            }
        }
        return head;
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
