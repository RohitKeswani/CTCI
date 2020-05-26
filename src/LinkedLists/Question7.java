package LinkedLists;

public class Question7 {
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1,2,3,4,5});
        ListNode head2 = ListNode.createList(new int[]{6});
        ListNode temp1 = head1;
        int count = 0;
        while(count<3){
            temp1 = temp1.next;
            count++;
        }
        ListNode temp2 = head2;
        while(temp2.next!=null){
            temp2 = temp2.next;
        }
        temp2.next = temp1;
        ListNode.printList(head1);
        System.out.println();
        ListNode.printList(head2);
        System.out.println();
        checkIntersection(head1, head2);
    }

    private static void checkIntersection(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        int length1 = 0, length2 = 0;
        while(temp1!=null){
            length1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            length2++;
            temp2 = temp2.next;
        }
        int difference = 0;
        if(length1>length2){
            difference = length1-length2;
            head1 = partialTraverse(difference, head1);
        }
        if(length1<length2){
            difference = length2-length1;
            head2 = partialTraverse(difference, head2);
        }
        //now both LL are of same size from head's.
        boolean isIntersected = false;
        while(head1!=null){
            if(head1.next == head2.next){
                isIntersected = true;
                break;
            }
            else
            {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        if(isIntersected){
            System.out.println("Intersection found: "+head1.next.val);
        }
        else
            System.out.println("Intersection not found");
    }

    private static ListNode partialTraverse(int difference, ListNode head) {
        int count = 0;
        while(count<difference){
            head = head.next;
            count++;
        }
        return head;
    }

}
