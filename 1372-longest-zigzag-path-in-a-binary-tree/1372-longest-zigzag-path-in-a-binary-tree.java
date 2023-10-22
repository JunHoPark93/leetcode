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
    List<TreeNode> nodes = new ArrayList<>();
    int maxCount = 0;

    // sol2
    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);

        return maxCount;
    }

    private void dfs(TreeNode node, boolean isLeft, int count) {
        if (node == null) {
            return;
        }

        maxCount = Math.max(count, maxCount);

        if (isLeft) {
            dfs(node.left, false, count + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, count + 1);
            dfs(node.left, false, 1);
        }
    }

    // sol1 - mine - 노드를 각각 탐색하니까 마지막에 timelimit에 걸린다. 
    // public int longestZigZag(TreeNode root) {
    //     // 모든 노드를 순회하면서 path중에서 가장 큰 값을 찾는다.
    //     // 모든 노드를 리스트에 담고 차례대로 DFS
    //     save(root);

    //     // left -> true, right -> false
    //     for (TreeNode n : nodes) {
    //         calculate(n.left, true, 0);
    //         calculate(n.right, false, 0);
    //     }

    //     return maxCount;
    // }
    
    // private void save(TreeNode node) {
    //     if (node == null) {
    //         return;
    //     }
    //     nodes.add(node);

    //     save(node.left);
    //     save(node.right);
    // }

    // private void calculate(TreeNode node, boolean side, int c) {
    //     if (node == null) {
    //         maxCount = Math.max(maxCount, c);
    //         return;
    //     }

    //     if (side) {
    //         calculate(node.right, false, c + 1);
    //     } else {
    //         calculate(node.left, true, c + 1);
    //     }
    // }
}