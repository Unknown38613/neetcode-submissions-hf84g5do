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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter; // edges
    }

    // height in NODES (null=0, leaf=1)
    private int height(TreeNode node) {
        if (node == null) return 0;
        int ln = height(node.left);
        int rn = height(node.right);
        diameter = Math.max(diameter, ln + rn); // edges through this node
        return 1 + Math.max(ln, rn);
    }
}