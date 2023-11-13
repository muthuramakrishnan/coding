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
    public boolean areMirrorImages(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if((node1 == null && node2!=null) || (node2 == null && node1!=null)){
            return false;
        }
        if(node1.val != node2.val){
            return false;
        }
        return areMirrorImages(node1.left, node2.right) && areMirrorImages(node1.right, node2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return areMirrorImages(root.left, root.right);
    }
}