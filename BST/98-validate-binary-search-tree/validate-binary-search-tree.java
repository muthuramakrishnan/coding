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
    long prevVal = Long.MIN_VALUE;
    public boolean findIsBst(TreeNode node){
        if(node == null){
            return true;
        }
        boolean isLeftBst = findIsBst(node.left);
        if(prevVal < node.val){
            prevVal = node.val;
        }
        else{
            return false;
        }
        boolean isRightBst = findIsBst(node.right);
        return isLeftBst && isRightBst;
    }
    public boolean isValidBST(TreeNode root) {
        return findIsBst(root);
    }
}