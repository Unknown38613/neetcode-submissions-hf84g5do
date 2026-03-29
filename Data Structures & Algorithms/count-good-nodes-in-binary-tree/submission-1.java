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
    int good = 0;
    public void dfs(TreeNode node, int maxValue){
        if(node == null) return;
        if(node.val >= maxValue) good += 1;
        maxValue = Math.max(node.val, maxValue);
        dfs(node.left, maxValue);
        dfs(node.right, maxValue);
    }
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return good;
    }
}