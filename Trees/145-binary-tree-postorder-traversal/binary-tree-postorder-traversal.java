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
    public void doTraversal(TreeNode root, List<Integer> outputList){
        if(root == null){
            return;
        }
        doTraversal(root.left, outputList);
        doTraversal(root.right, outputList);
        outputList.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        doTraversal(root, outputList);
        return outputList;
    }
}