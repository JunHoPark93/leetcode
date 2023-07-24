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
    public int maxLevelSum(TreeNode root) {
        // define cur, next queue
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        // put root to the current queue
        cur.offer(root);
        next.offer(root);

        int level = 1;
        Map<Integer, Integer> result = new HashMap<>();

        while (!next.isEmpty()) {     
            cur = next;   
            next = new LinkedList<>();

            int sum = 0;

            while (!cur.isEmpty()) {
                TreeNode node = cur.poll();
                sum += node.val;

                if (node.left != null) {
                    next.offer(node.left);
                }

                if (node.right != null) {
                    next.offer(node.right);
                }
            }

            result.put(level, sum);
            level++;
        }

        // while current is empty poll the value
        // put child to next queue
        // sum all the child & put the value to result list

        return result.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
        .get().getKey();
    }
}