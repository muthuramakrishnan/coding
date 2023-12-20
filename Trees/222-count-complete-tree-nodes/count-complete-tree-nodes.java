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
    public boolean checkIsNull(TreeNode node, int n, int low, int high){
        if(n > high){
            return true;
        }
        while(low<high){
            int mid = low + (high - low) / 2;
            if(mid >= n){
                high = mid;
                node = node.left;
            }
            else{
                low = mid + 1;
                node = node.right;
            }
        }
        return node == null;
    }
    public int getHeight(TreeNode node){
        int count = 0;
        while(node!=null){
            node = node.left;
            count++;
        }
        return count;
    }
    public int getSumOfNTerms(int ratio, int a, int n){
        return (a * ((int)Math.pow(ratio, n) - 1)) / (ratio - 1);
    }
    public int countNodes(TreeNode node) {
        int height = getHeight(node);
        int totalNodesInLastRow = (int) Math.pow(2, height - 1);
        int low = 1;
        int high = totalNodesInLastRow;

        while(low<=high){
            int mid = low + (high - low) / 2;
            boolean isNull = checkIsNull(node, mid, 1, totalNodesInLastRow);
            if(isNull){
                high = mid - 1;
            }
            else{
                if(checkIsNull(node, mid+1, 1, totalNodesInLastRow)){
                    return getSumOfNTerms(2, 1, height - 1) + mid;
                }
                else{
                    low = mid + 1;
                }
            }
        }
        return 0;
    }
}