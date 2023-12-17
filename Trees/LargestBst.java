//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    private static int largestBst = 0;
    private static final class NodeInfo{
        long maxVal;
        long minVal;
        int treeLen;
        boolean isBst;
    }
    
    static NodeInfo findIsBst(Node node){
        if(node == null){
            NodeInfo nodeInfo = new NodeInfo();
            nodeInfo.maxVal = Long.MIN_VALUE;
            nodeInfo.minVal = Long.MAX_VALUE;
            nodeInfo.isBst = true;
            nodeInfo.treeLen = 0;
            return nodeInfo;
        }
        
        NodeInfo isLeftBst = findIsBst(node.left);
        NodeInfo isRightBst = findIsBst(node.right);
        
        NodeInfo nodeInfo = new NodeInfo();
        nodeInfo.minVal = Math.min(node.data, Math.min(isLeftBst.minVal, isRightBst.minVal));
        nodeInfo.maxVal = Math.max(node.data, Math.max(isLeftBst.maxVal, isRightBst.maxVal));
        nodeInfo.isBst = isLeftBst.isBst && isRightBst.isBst && node.data > isLeftBst.maxVal && node.data < isRightBst.minVal;
        nodeInfo.treeLen = isLeftBst.treeLen + isRightBst.treeLen + 1;
        if(nodeInfo.isBst){
            // System.out.println(node.data);
            largestBst = Math.max(nodeInfo.treeLen, largestBst);
        }
        return nodeInfo;
        
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        largestBst = 0;
        findIsBst(root);
        return largestBst;
        
    }
    
}