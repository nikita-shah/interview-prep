package dsa.linkedlist;

//Handling corner cases in linked list is super imp.

public class ReOrderList {
    public ListNode reorderList(ListNode A) {

        //reverse the second half of list
        //find the half using slow and fast pointer.
        //next of first half to null , use previous to slow pointer so that it can be made null.
        //now reverse the list slow pointer onwards, after reverse, the head is expected in slow pointer.
        //now link alternate nodes from head pointer and slow pointer

        if(A.next == null || A.next.next == null) return A;

        ListNode half = breakList(A);
        System.out.println("half");
        printList(half);
        System.out.println("reversed");
        ListNode reversedHalf = reverse(half);
        printList(reversedHalf);
        ListNode head = A;

        while(A!=null && reversedHalf!=null)
        {
            ListNode temp1 = A.next;
            ListNode temp2 = reversedHalf.next;

            A.next = reversedHalf;
            reversedHalf.next = temp1 == null?reversedHalf.next  : temp1;

            A = temp1;
            reversedHalf = temp2;

        }
        System.out.println("final");
        printList(head);
        return head;

    }

    private ListNode breakList(ListNode A)
    {
        if(A.next == null)
            return A;

        if(A.next.next ==null)
            return A.next;

        ListNode slow = A;
        ListNode prev = null;
        ListNode fast = A;

        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        prev.next = null;
        return slow;

    }

    private  ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode nxt = null;
        ListNode curr = head;

        while(curr!=null)
        {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }

    private void printList (ListNode head)
    {
        while(head!=null)
        {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
