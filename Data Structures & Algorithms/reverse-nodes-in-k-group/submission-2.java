class Solution {
    // Optional: standard LeetCode ListNode for local testing
    // static class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head
    }

    // Iterative length to avoid recursion depth issues
    public int lengthOfList(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    // Iterative kth node (1-indexed). Returns null if fewer than k nodes remain.
    public ListNode knodes(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node; // either kth node or null
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        int len = lengthOfList(head);
        int groups = len / k;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode startNode = head;

        while (groups > 0) {
            ListNode start = startNode;              // start of this k-group
            ListNode endNode = knodes(startNode, k); // kth node
            // endNode is guaranteed non-null because groups = len / k
            ListNode nextGroupHead = endNode.next;   // remember the next group
            endNode.next = null;                     // detach this k-group

            // reverse the detached k-group and attach it
            curr.next = reverseList(start);

            // 'start' is now the tail of the reversed group: hop in O(1)
            curr = start;

            // move to next group
            startNode = nextGroupHead;
            groups--;
        }

        // attach any remaining nodes (< k)
        curr.next = startNode;
        return dummy.next;
    }
}