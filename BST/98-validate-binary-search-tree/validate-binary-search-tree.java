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
    public boolean checkIsBst(TreeNode node, long lb, long ub){
        if(node == null){
          return true;
        }
        boolean isLeftBst = checkIsBst(node.left, lb, node.val);
        boolean isRightBst = checkIsBst(node.right, node.val, ub);
        return isLeftBst && isRightBst && (node.val > lb) && (node.val < ub);
    }
    public boolean isValidBST(TreeNode root) {
        return checkIsBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}