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
//[1,2,3,4,5,6,7]
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = queue.poll();
                if(i == size - 1) ans.add(curr.val); //for left view (i == 0)
                if(curr.left != null) queue.offer(curr.left); //2, 4, 6
                if(curr.right != null) queue.offer(curr.right); //3, 5, 7
                //suppose 7 is not there then rightmost will be 6, then 5, then 4
            }
        }
        return ans;
    }
}