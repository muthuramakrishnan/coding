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
    public void doCreateBst(int[] arr, int lb, int ub, TreeNode node) {
        if (lb > ub) {
            return;
        }
        int mid = (lb + ub) / 2;
        node.val = arr[mid];

        TreeNode leftNode = lb > mid - 1 ? null : new TreeNode();
        TreeNode rightNode = mid + 1 > ub ? null : new TreeNode();
        node.left = leftNode;
        node.right = rightNode;
        doCreateBst(arr, lb, mid - 1, node.left);
        doCreateBst(arr, mid + 1, ub, node.right);

    }

    public TreeNode convertToBst(int[] arr) {
        TreeNode root = new TreeNode();
        doCreateBst(arr, 0, arr.length - 1, root);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] arr) {
        return convertToBst(arr);
    }
}