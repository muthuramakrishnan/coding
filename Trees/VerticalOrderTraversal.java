class Solution
{
    private static class MetaData{
        int data;
        int level;
        int horizontalDist;
    }
    public static ArrayList<Integer> getVerticalList(ArrayList<MetaData> metaDataList){
        ArrayList<Integer> verticalList = new ArrayList<>();
        for(MetaData metaData : metaDataList){
            verticalList.add(metaData.data);
        }
        return verticalList;
    }
    public static void traverse(Node node, int level, int horizontalDist, ArrayList<MetaData> list){
        if(node == null){
            return;
        }
        MetaData metaData = new MetaData();
        metaData.data = node.data;
        metaData.level = level;
        metaData.horizontalDist = horizontalDist;
        list.add(metaData);
        traverse(node.left, level + 1, horizontalDist - 1, list);
        traverse(node.right, level + 1, horizontalDist + 1, list);
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        ArrayList<MetaData> metaDataList = new ArrayList<>();
        int level = 0;
        int horizontalDist = 0;
        traverse(root, level, horizontalDist, metaDataList);
        metaDataList.sort((a, b) -> {
            if(a.horizontalDist == b.horizontalDist){
                return a.level - b.level;
            }
            else{
                return a.horizontalDist - b.horizontalDist;
            }
        });
        return getVerticalList(metaDataList);
    }
}