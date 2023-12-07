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
    public NodeInfoObj isSubTreeBst(TreeNode node){
        NodeInfoObj nodeInfo = new NodeInfoObj();
        if(node == null){
            nodeInfo.maxVal = Long.MIN_VALUE;
            nodeInfo.minVal = Long.MAX_VALUE;
            nodeInfo.isBst = true;
            return nodeInfo;
        }

        NodeInfoObj leftNodeInfo = isSubTreeBst(node.left);
        NodeInfoObj rightNodeInfo = isSubTreeBst(node.right);

        NodeInfoObj currNodeInfo = new NodeInfoObj();
        currNodeInfo.isBst = leftNodeInfo.isBst && rightNodeInfo.isBst && (node.val > leftNodeInfo.maxVal) && (node.val < rightNodeInfo.minVal);
        currNodeInfo.minVal = Math.min(Math.min(leftNodeInfo.minVal, node.val), rightNodeInfo.minVal);
        currNodeInfo.maxVal = Math.max(Math.max(leftNodeInfo.maxVal, node.val), rightNodeInfo.maxVal);
        return currNodeInfo;
    }
    public boolean isValidBST(TreeNode root) {
        NodeInfoObj nodeInfo = isSubTreeBst(root);
        return nodeInfo.isBst;
    }
}

class NodeInfoObj{
    public long maxVal;
    public long minVal;
    public boolean isBst;
}