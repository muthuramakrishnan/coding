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
        outputList.add(root.val);
        doTraversal(root.left, outputList);
        doTraversal(root.right, outputList);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> outputList = new ArrayList<>();
        doTraversal(root, outputList);
        return outputList;
    }
}