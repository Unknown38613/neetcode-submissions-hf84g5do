/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSame(TreeNode first, TreeNode second){
        if(first == null || second == null) return first == second;
        return first.val == second.val 
            && isSame(first.left, second.left)
            && isSame(first.right, second.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }
}