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
    public int findHeight(TreeNode root, Map<TreeNode, Integer> htMap){
        if(root == null){
            return 0;
        }
        int leftDepth = findHeight(root.left, htMap);
        int rightDepth = findHeight(root.right, htMap);
        int height = 1 + Math.max(leftDepth, rightDepth);
        htMap.put(root, height);
        return height;
    }
    public int findDiameter(TreeNode root, Map<TreeNode, Integer> htMap){
        if(root == null){
            return 0;
        }
        int leftHeight = htMap.containsKey(root.left) ? htMap.get(root.left) : findHeight(root.left, htMap);
        int rightHeight = htMap.containsKey(root.right) ? htMap.get(root.right): findHeight(root.right, htMap);
        int diameter = 1 + leftHeight + rightHeight;
        int maxOfLeftRight = Math.max(findDiameter(root.left, htMap), findDiameter(root.right, htMap));
        return Math.max(diameter, maxOfLeftRight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftLevel = 0;
        int rightLevel = 0;
        Map<TreeNode, Integer> htMap = new HashMap<>();
        return findDiameter(root, htMap) - 1;
    }
}