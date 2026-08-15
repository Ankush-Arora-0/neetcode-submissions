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
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode i=head,j=head.next;
        while(i!=null && j!=null && j.next!=null){
            if(i.val==j.val)return true;
            i = i.next;
            j = j.next.next;
        }
        return false;
    }
}
