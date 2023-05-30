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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // check last node -> put into list

        List<Integer> result1 = new ArrayList();
        findLast(root1, result1);

        List<Integer> result2 = new ArrayList();
        findLast(root2, result2);

        return result1.equals(result2);
    }

    private void findLast(TreeNode node, List<Integer> result) {
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        if (node.left != null) {
            findLast(node.left, result);
        }
        if (node.right != null) {
            findLast(node.right, result);
        }
    }
}