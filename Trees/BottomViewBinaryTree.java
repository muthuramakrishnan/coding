class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> bottomView(Node node)
    {
    // add your code
        if(node == null){
            return new ArrayList<>();
        }
        
        Queue<NodeDetail> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        int startIdx = 0;
        int endIdx = 0;
        int currentLevel = -1;
        
        NodeDetail nodeDetail = new NodeDetail();
        nodeDetail.node = node;
        nodeDetail.level = 0;
        
        queue.add(nodeDetail);
        
        while(!queue.isEmpty()){
            NodeDetail element = queue.remove();
            int currAdjacentDist = element.adjacentDist;
            int level = element.level;
            startIdx = Math.min(startIdx, currAdjacentDist);
            endIdx = Math.max(endIdx, currAdjacentDist);
            if(level > currentLevel){
                currentLevel++;
            }
            else{
                //do nothing
            }
            // if(!map.containsKey(currAdjacentDist)){
                map.put(currAdjacentDist, element.node.data);
            // }
            
            if(element.node.left != null){
                NodeDetail leftNodeDetail = new NodeDetail();
                leftNodeDetail.node = element.node.left;
                leftNodeDetail.adjacentDist = currAdjacentDist - 1;
                leftNodeDetail.level = currentLevel + 1;
                queue.add(leftNodeDetail);
            }
            
            if(element.node.right != null){
                NodeDetail rightNodeDetail = new NodeDetail();
                rightNodeDetail.node = element.node.right;
                rightNodeDetail.adjacentDist = currAdjacentDist + 1;
                rightNodeDetail.level = currentLevel + 1;
                queue.add(rightNodeDetail);
            }
            
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=startIdx; i<=endIdx; i++){
            list.add(map.get(i));
        }
        return list;
        
    }
    
    static class NodeDetail{
        Node node;
        int adjacentDist;
        int level;
    }
}