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
    public int getMinimumDifference(TreeNode root) {
        // 트리에 있는 모든 값들을 배열에 넣는다.
        // 정렬을 한다.
        // 배열을 1번 순회하며 인접원소의 최소의 차이를 찾는다.
        List<Integer> elems = new ArrayList<>();

        add(root, elems);

        Collections.sort(elems);

        return findMinGap(elems);
    }

    private void add(TreeNode node, List<Integer> elems) {
        if (node == null) {
            return;
        }
        elems.add(node.val);
        
        add(node.left, elems);
        add(node.right, elems);
    }

    private int findMinGap(List<Integer> elems) {
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < elems.size() - 1; i++) {
            int first = elems.get(i);
            int second = elems.get(i + 1);
            minGap = Math.min(Math.abs(first - second), minGap);
        }
        return minGap;
    }
}