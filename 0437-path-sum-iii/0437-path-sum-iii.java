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
    List<TreeNode> targets = new ArrayList<>();
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        // DFS
        // 트리를 위에서 부터 쭉 순회하면서
            // 해당 노드부터 합계를 쭉 구한다 target이 맞다면 count 증가

        if (root == null) {
            return 0;
        }
        
        loop(root);
        for (TreeNode n : targets) {
            traverse(n, 0, targetSum);
        }

        return count;
    }

    private void loop(TreeNode node) {
        if (node == null) {
            return;
        }
        targets.add(node);
        loop(node.left);
        loop(node.right);
    }

    private void traverse(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return;
        }

        if (node.val == Math.pow(10, 9)) {
            return;
        }

        sum += node.val;

        if (sum == targetSum) {
            count++;
        }

        traverse(node.left, sum, targetSum);
        traverse(node.right, sum, targetSum);
        sum = sum - node.val;
    }
}