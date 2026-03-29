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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inIdx = 0;
        for(int i = 1 ; i < preorder.length ; i++){
            int curr = preorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[inIdx]){
                node.left = new TreeNode(curr);
                stack.push(node.left);
            }
            else{
                while(!stack.isEmpty() && stack.peek().val == inorder[inIdx]){
                    node = stack.pop();
                    inIdx += 1;
                }
                node.right = new TreeNode(curr);
                stack.push(node.right);
            }
        }
        return root;
    }
}
