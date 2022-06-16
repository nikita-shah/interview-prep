package dsa.linkedlist;

public class MainClass {

    public static void main(String[]args)
    {
    //creating a linked list
     ListNode g = new ListNode(7,null);
    ListNode f = new ListNode(6,g);
    ListNode e = new ListNode(5,f);
    ListNode d = new ListNode(4,e);
    ListNode c = new ListNode(3,d);
    ListNode b = new ListNode(2,c);
    ListNode a = new ListNode(1,b);



   ReOrderList reOrderList = new ReOrderList();
   reOrderList.reorderList(a);



    }





}
