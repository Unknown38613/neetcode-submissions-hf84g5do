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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode ans = new ListNode();
        ListNode curr = ans;
        int carry = 0;
        while(first != null && second != null){
            int fnum = first.val;
            int snum = second.val;
            int sum = fnum + snum + carry;
            if(sum > 9){             
               ListNode sumnode = new ListNode(sum % 10);
               curr.next = sumnode;
               carry = 1;
            }
            else{
               ListNode sumnode = new ListNode(sum);
               curr.next = sumnode;
               carry = 0;
            }
            curr = curr.next;
            first = first.next;
            second = second.next;
        }
        while(first != null){
            int sum = first.val + carry;
            if(sum > 9){
                ListNode sumnode = new ListNode(sum % 10);
                curr.next = sumnode;
                carry = 1;
            }
            else{
                ListNode sumnode = new ListNode(sum);
                curr.next = sumnode;
                carry = 0;
            }
            curr = curr.next;
            first = first.next;
        } 
        while(second != null){
            int sum = second.val + carry;
            if(sum > 9){
                ListNode sumnode = new ListNode(sum % 10);
                curr.next = sumnode;
                carry = 1;
            }
            else{
                ListNode sumnode = new ListNode(sum);
                curr.next = sumnode;
                carry = 0;
            }
            curr = curr.next;
            second = second.next;
        }
        if(carry != 0){
            ListNode carrynode = new ListNode(carry);
            curr.next = carrynode;
        }
        return ans.next;
    }
}
