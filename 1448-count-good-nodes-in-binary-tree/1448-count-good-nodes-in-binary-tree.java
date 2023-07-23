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
    private int count = 0;

    public int goodNodes(TreeNode root) {
        find(root, root.val);   

        return count; 
    }

    private void find(TreeNode node, int compare) {
        if (node.val >= compare) {
            count++;
        }
        
        if (node.left != null) {
            find(node.left, Math.max(node.val, compare));
        }

        if (node.right != null) {
            find(node.right, Math.max(node.val, compare));
        }
    }
}