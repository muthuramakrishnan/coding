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
    enum TREE_BRANCH {
        LEFT_BRANCH,
        RIGHT_BRANCH;
    }
    public boolean isPerfect(TreeNode node){
        int leftCount = getHeight(node, TREE_BRANCH.LEFT_BRANCH);
        int rightCount = getHeight(node, TREE_BRANCH.RIGHT_BRANCH);
        return leftCount == rightCount;
    }
    public int getHeight(TreeNode node, TREE_BRANCH treeBranch){
        int count = 0;
        while(node != null){
            node = treeBranch == TREE_BRANCH.LEFT_BRANCH ? node.left : node.right;
            count++;
        }
        return count;
    }
    public int findCounts(TreeNode node){
        if(node == null){
            return 0;
        }

        boolean isLeftTreePerfect = isPerfect(node.left);
        boolean isRightTreePerfect = isPerfect(node.right);

        int leftTreeCount = isLeftTreePerfect ? (int)Math.pow(2, getHeight(node.left, TREE_BRANCH.LEFT_BRANCH)) - 1 : findCounts(node.left);
        int rightTreeCount = isRightTreePerfect ? (int)Math.pow(2, getHeight(node.right, TREE_BRANCH.LEFT_BRANCH)) - 1 : findCounts(node.right);

        return leftTreeCount + rightTreeCount + 1;
    }
    public int countNodes(TreeNode node) {
        return findCounts(node);
    }
}