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
    private ListNode findMiddleNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head){
        if(head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode middleNode = findMiddleNode(head);
        ListNode secondListStart = middleNode.next;
        middleNode.next = null;
        ListNode secondListHead = reverseList(secondListStart);
        ListNode fs = head, ss = secondListHead;
        while(ss != null){
            ListNode fnext = fs.next, snext = ss.next;
            fs.next = ss;
            ss.next = fnext;
            fs = fnext;
            ss = snext;
        }
    }
}
