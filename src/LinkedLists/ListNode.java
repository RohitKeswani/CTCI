package LinkedLists;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createNode(int val){
        return new ListNode(val, null);
    }

    public static ListNode createList(int[] vals){
        ListNode head = createNode(vals[0]);
        ListNode prev = head;
        for(int i = 1; i< vals.length; i++){
            ListNode newNode = createNode(vals[i]);
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }

    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            if(temp.next == null){
                System.out.print(temp.val);
            }
            else
                System.out.print(temp.val+"-->");
            temp = temp.next;
        }
    }

}
