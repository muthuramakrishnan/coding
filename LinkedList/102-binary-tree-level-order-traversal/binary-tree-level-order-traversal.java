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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<NodeDetail> queue = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        if(root == null){
            return output;
        }
        int currentLevel = -1;
        NodeDetail nodeDetail = new NodeDetail();
        nodeDetail.node = root;
        nodeDetail.level = currentLevel + 1;
        queue.add(nodeDetail);

        List<Integer> levelList = null;
        while(!queue.isEmpty()){
            NodeDetail element = queue.remove();
            if(element.level > currentLevel)
            {
                if(currentLevel != -1)
                 {  
                     output.add(levelList);
                 }
                 currentLevel++;
                 levelList = new ArrayList<>();
                 levelList.add(element.node.val);
            }
            else{
                levelList.add(element.node.val);
            }
            NodeDetail leftNodeDetail = new NodeDetail();
            NodeDetail rightNodeDetail = new NodeDetail();

            if(element.node.left!=null){
                leftNodeDetail.node = element.node.left;
                leftNodeDetail.level = currentLevel + 1;
                queue.add(leftNodeDetail);
            }
            if(element.node.right!=null){
                rightNodeDetail.node = element.node.right;
                rightNodeDetail.level = currentLevel + 1;
                queue.add(rightNodeDetail);
            }
        }
        if(levelList.size() > 0){
            output.add(levelList);
        }
        return output;
    }
}

class NodeDetail{
    public TreeNode node;
    public int level;
}