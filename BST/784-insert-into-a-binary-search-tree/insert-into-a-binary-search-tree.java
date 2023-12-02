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
    public void insert(TreeNode node, TreeNode parent, int val){
        if(node == null){
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            if(val > parent.val){
                parent.right = newNode;
            }
            else{
                parent.left = newNode;
            }
            return;
        }
        if(val > node.val){
            insert(node.right, node, val);
        }
        else{
            insert(node.left, node, val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode();
            root.val = val;
            return root;
        }

        insert(root, null, val);
        return root;
    }
}