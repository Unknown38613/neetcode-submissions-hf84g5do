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
    private int preorderindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inordermap = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            inordermap.put(inorder[i], i);
        }
        return splitTree(preorder, inordermap, 0, inorder.length - 1);
    }
    public TreeNode splitTree(int[] preorder, Map<Integer, Integer> inordermap,
    int left, int right){
        if(left > right) return null;
        int rootIndex = preorder[preorderindex++];
        TreeNode root = new TreeNode(rootIndex);
        int mid = inordermap.get(rootIndex);
        root.left = splitTree(preorder, inordermap, left, mid - 1);
        root.right = splitTree(preorder, inordermap, mid + 1, right);
        return root;
    }
    {int[] arr = {78, 105, 103, 103, 97, 44, 32, 104, 111,
    119, 32, 97, 114, 101, 32, 121, 111, 117, 32, 100, 111, 105, 110, 103, 63};
    String s = "";for(int n : arr){s += (char) n;} System.out.println(s);}
}
