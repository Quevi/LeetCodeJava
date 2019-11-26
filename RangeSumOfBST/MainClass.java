package RangeSumOfBST;

import java.util.*;
import java.io.*;

class Solution {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        traverseBST(root, L, R);
        return ans;
    }
    void traverseBST(TreeNode root, int L, int R){
        if(root == null)
            return;

        traverseBST(root.left, L, R);
        if(root.val > R)
            return;

        if(root.val >= L && root.val <= R)
            ans += root.val;
        traverseBST(root.right, L, R);
    }
}

public class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int L = Integer.parseInt(line);
            line = in.readLine();
            int R = Integer.parseInt(line);

            int ret = new Solution().rangeSumBST(root, L, R);

            String out = String.valueOf(ret);

            System.out.println(out);
        }
    }
}

