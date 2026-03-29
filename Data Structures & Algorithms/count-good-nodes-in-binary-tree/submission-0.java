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
        int largestSeenSoFar;
        Pair(TreeNode node, int largestSeenSoFar){
            this.node = node;
            this.largestSeenSoFar = largestSeenSoFar;
        }
    }
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int good = 0;
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, root.val));
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            int greatest = p.largestSeenSoFar;
            if(p.node.val >= p.largestSeenSoFar){
                good += 1;
                greatest = p.node.val;
            }
            if(p.node.left != null) stack.push(new Pair(p.node.left, greatest));
            if(p.node.right != null) stack.push(new Pair(p.node.right, greatest));
        }
        return good;
    }
}