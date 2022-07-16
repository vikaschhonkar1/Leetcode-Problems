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
    public ListNode reverseList(ListNode head) {
        if(head==null)  return null;
        if(head.next==null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode forward = null;
        
        while(curr!=null){
            forward = curr.next; //for backup
            curr.next = prev;   //atteching link
            prev = curr;
            curr = forward;
        }
        
        return prev;
    }
}