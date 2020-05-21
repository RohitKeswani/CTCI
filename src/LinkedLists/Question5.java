package LinkedLists;

public class Question5 {
    public static void main(String[] args) {
        ListNode firstList = ListNode.createList(new int[]{8,7,6});
        ListNode secondList = ListNode.createList(new int[]{9,4});
        addList(firstList, secondList);
    }

    private static void addList(ListNode firstList, ListNode secondList) {
        ListNode resultList = null;
        ListNode temp = null;
        ListNode prev = null;
        int sum, carry = 0;

        while(firstList!=null || secondList!=null){
            sum = carry+(firstList!=null?firstList.val:0)+(secondList!=null? secondList.val: 0);
            if(sum > 9){
                sum = sum %10;
                carry = 1;
            }
            else
                carry = 0;
            temp = new ListNode(sum, null);
            if(resultList == null)
                resultList = temp;
            else
                prev.next = temp;
            prev = temp;
            if(firstList!=null)
                firstList = firstList.next;
            if(secondList!=null)
                secondList = secondList.next;
        }
        if(carry ==1){
            temp = new ListNode(carry, null);
            prev.next = temp;
        }
        printSum(resultList);
    }

    private static void printSum(ListNode resultList) {
        int count = 0;
        ListNode temp = resultList;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        int[] result = new int[count];
        int i = 0;
        while(resultList!=null){
            result[i] = resultList.val;
            resultList = resultList.next;
            i++;
        }
        for(i = result.length-1; i>=0; i--){
            System.out.print(result[i]+"");
        }
        System.out.println();
    }
}
