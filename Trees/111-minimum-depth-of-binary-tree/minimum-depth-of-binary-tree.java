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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if((leftDepth == 0 && rightDepth == 0) || (leftDepth!=0 && rightDepth!=0)){
            return 1 + Math.min(leftDepth, rightDepth);
        }
        return 1 + Math.min(leftDepth == 0 ? rightDepth : leftDepth, rightDepth == 0 ? leftDepth : rightDepth);
    }
}