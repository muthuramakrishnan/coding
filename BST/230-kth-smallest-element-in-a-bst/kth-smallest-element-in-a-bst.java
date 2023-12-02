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
    int count = 1;
    public int findKthSmallestByTraversing(TreeNode node, int k, int smallestVal){
        if(node == null){
            return smallestVal;
        }
        int leftSmallest = findKthSmallestByTraversing(node.left, k, smallestVal);
        int currSmallest = k == count ? node.val : smallestVal;
        count++;
        int rightSmallest = findKthSmallestByTraversing(node.right, k, smallestVal);

         int temp =  Math.min(leftSmallest, currSmallest);
         return Math.min(temp, rightSmallest);
    }
    public int kthSmallest(TreeNode root, int k) {
        return findKthSmallestByTraversing(root, k, Integer.MAX_VALUE);
    }
}