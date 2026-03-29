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
        if(head == null) return null;
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

    public int lengthOfList(ListNode node){
        if(node == null) return 0;
        return 1 + lengthOfList(node.next);
    }

    public ListNode knodes(ListNode node, int k){
        if(node == null || k == 1) return node;
        return knodes(node.next, k - 1);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = lengthOfList(head);
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int count = len / k;
        ListNode startNode = head;
        while(count != 0){
            ListNode start = startNode;
            ListNode endNode = knodes(startNode, k);
            if(endNode != null){
                startNode = endNode.next;
                endNode.next = null;
            } else startNode = null;
            curr.next = reverseList(start);
            while(curr.next != null) curr = curr.next;
            count -= 1;
        }
        curr.next = startNode;
        return dummy.next;
    }
}
