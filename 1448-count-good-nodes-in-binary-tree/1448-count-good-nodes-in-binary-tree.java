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
    public int goodNodes(TreeNode root) {
        int count = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, root.val));
        
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();

            if (pair.node.val >= pair.val) {
                count++;
            }

            if (pair.node.left != null) {
                stack.push(new Pair(pair.node.left, Math.max(pair.node.val, pair.val)));
            }

if (pair.node.right != null) {
                stack.push(new Pair(pair.node.right, Math.max(pair.node.val, pair.val)));
            }

        }
        return count;
    }

    class Pair {
        TreeNode node;
        int val;
        
        public Pair(TreeNode node, int val) {
            this.node = node;
            this.val = val;
        }
    }
}










