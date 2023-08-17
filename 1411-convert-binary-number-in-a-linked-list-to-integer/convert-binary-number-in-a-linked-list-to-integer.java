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

// val = val * base + digit
class Solution {
    public int getDecimalValue(ListNode head) {
        int val = head.val;
        int power = 0;
        ListNode temp = head;
        while(temp.next != null) {
            val = val * 2 + temp.next.val;
            temp = temp.next;
        }
        return val;
    }
}