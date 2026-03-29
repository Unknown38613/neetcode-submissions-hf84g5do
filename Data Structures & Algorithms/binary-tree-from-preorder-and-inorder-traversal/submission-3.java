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
        TreeNode root = new TreeNode(preorder[0]); //preorder contains root first
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inIdx = 0; //pointer to keep track of inorder left and right part
        for(int i = 1 ; i < preorder.length ; i++){
            int curr = preorder[i]; //new node to be created
            TreeNode node = stack.peek(); //already created
            if(node.val != inorder[inIdx]){ //left subtree i.e root -> left
                node.left = new TreeNode(curr);
                stack.push(node.left);
            }
            else{ //right subtree
        //root -> left done, now stack stored them in left -> root exactly like inorder
        //so pop the done nodes of left subtree
                while(!stack.isEmpty() && stack.peek().val == inorder[inIdx]){
                    node = stack.pop();
                    inIdx += 1;
                }
                //attach new node to right of previous popped element
                node.right = new TreeNode(curr);
                stack.push(node.right);
            }
        }
        return root;
    }
}