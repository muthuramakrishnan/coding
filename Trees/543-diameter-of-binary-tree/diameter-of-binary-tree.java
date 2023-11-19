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
    public int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = findHeight(root.left);
        int rightDepth = findHeight(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
    public int findDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int diameter = 1 + leftHeight + rightHeight;
        int maxOfLeftRight = Math.max(findDiameter(root.left), findDiameter(root.right));
        return Math.max(diameter, maxOfLeftRight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return findDiameter(root) - 1;
    }
}