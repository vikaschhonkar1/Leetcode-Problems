/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode newnode=temp;
        
        while(l1!=null &&  l2!=null){
            if(l1.val < l2.val){
                newnode.next=new ListNode(l1.val);
                newnode=newnode.next;
                l1=l1.next;
            }
            else{
                newnode.next= new ListNode(l2.val);
                newnode=newnode.next;
                l2=l2.next;
            }
        }
		
        if (l1 != null) newnode.next = l1;
        else if (l2 != null) newnode.next = l2;
        
        return temp.next;
    }
}