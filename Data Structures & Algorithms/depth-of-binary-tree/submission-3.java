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
    static class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 1));
        int maxdepth = 0;
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            maxdepth = Math.max(maxdepth, p.depth);
            if(p.node.left != null) stack.push(new Pair(p.node.left, p.depth + 1));
            if(p.node.right != null) stack.push(new Pair(p.node.right, p.depth + 1));
        }
        return maxdepth;
    }
}