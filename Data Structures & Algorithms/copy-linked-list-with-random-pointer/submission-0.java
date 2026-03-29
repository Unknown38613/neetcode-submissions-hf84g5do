/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//A -> clone(A) -> B -> clone(B) -> null
class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null){
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }
        curr = head;
        while(curr != null){
            Node temp = curr.random;
            Node clone = curr.next;
            if(temp != null) clone.random = temp.next;
            else clone.random = null;
            curr = curr.next.next;
        }
        Node dummy = new Node(-1);
        Node copylist = dummy;
        curr = head;
        while(curr != null){
            copylist.next = curr.next;
            curr.next = curr.next.next;
            copylist = copylist.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
