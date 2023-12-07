package BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateBst {

    public static void doInorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        doInorderTraversal(node.left);
        System.out.printf("%d, ", node.val);
        doInorderTraversal(node.right);
    }

    public static void doCreateBst(int[] arr, int lb, int ub, TreeNode node) {
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

    public static TreeNode convertToBst(int[] arr) {
        TreeNode root = new TreeNode();
        doCreateBst(arr, 0, arr.length - 1, root);
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        TreeNode root = convertToBst(arr);
        doInorderTraversal(root);
    }
}
