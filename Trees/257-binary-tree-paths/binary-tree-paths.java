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
    public void findBinaryTreePaths(TreeNode root, List<String> paths, Stack<Integer> tempListPaths, int level){
        if(root == null){
            return;
        }
        tempListPaths.push(root.val);
        if(root.left == null && root.right == null){
            int count = 1;
            StringBuilder sb = new StringBuilder();
            // System.out.println(tempListPaths);
            for(int item : tempListPaths){
                if(count == level){
                    sb.append(item);
                }
                else{
                    sb.append(item + "->");
                }
                count++;
            }
            paths.add(sb.toString());
            tempListPaths.pop();
            return;
        }
        findBinaryTreePaths(root.left, paths, tempListPaths, level + 1);
        findBinaryTreePaths(root.right, paths,tempListPaths, level + 1);
        tempListPaths.pop();
        // System.out.println(tempListPaths.pop());
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        Stack<Integer> tempListPaths = new Stack<>();
        findBinaryTreePaths(root, paths, tempListPaths, 1);
        return paths;
    }
}