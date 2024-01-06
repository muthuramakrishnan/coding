import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AllPossibleTrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void traverse(TreeNode node, String nodeLocation) {
        if (node == null) {
            return;
        }
        System.out.printf("%s %d, ", nodeLocation, node.val);
        traverse(node.left, "left");
        traverse(node.right, "right");
    }

    public static List<TreeNode> generateTreeFor(int n) {
        List<TreeNode> list = new ArrayList<>();

        if (n == 0) {
            list.add(null);
            return list;
        }
        if (n == 1) {
            TreeNode node = new TreeNode();
            node.val = 0;
            list.add(node);
            return list;
        }
        for (int i = 0; i < n; i++) {
            // left side nodes -> i
            // right side nodes -> n - 1 - i;
            List<TreeNode> leftTrees = generateTreeFor(i);
            List<TreeNode> rightTrees = generateTreeFor(n - 1 - i);

            for (TreeNode leftNode : leftTrees) {
                for (TreeNode rightNode : rightTrees) {
                    TreeNode node = new TreeNode();
                    node.val = 0;
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);

        List<TreeNode> rootList = generateTreeFor(n);
        for (TreeNode root : rootList) {
            traverse(root, "root");
            System.out.println();
        }
    }
}
