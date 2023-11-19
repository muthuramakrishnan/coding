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
    public NodeInfo computeHeight(TreeNode root){
        NodeInfo returnNodeInfo = new NodeInfo();
        if(root == null){
            returnNodeInfo.height = 0;
            returnNodeInfo.isSubTreeBalanced = true;
            return returnNodeInfo;
        }
        NodeInfo leftNodeInfo = computeHeight(root.left);
        NodeInfo rightNodeInfo = computeHeight(root.right);
        int currSubTreeHeight = Math.abs(leftNodeInfo.height - rightNodeInfo.height);
        returnNodeInfo.height = 1 + Math.max(leftNodeInfo.height, rightNodeInfo.height);
        returnNodeInfo.isSubTreeBalanced = leftNodeInfo.isSubTreeBalanced && rightNodeInfo.isSubTreeBalanced && currSubTreeHeight <=1;
        return returnNodeInfo;

    }
    public boolean isBalanced(TreeNode root) {
        NodeInfo nodeInfo = computeHeight(root);
        return nodeInfo.isSubTreeBalanced;
    }
}

class NodeInfo {
    public int height;
    public boolean isSubTreeBalanced;
}