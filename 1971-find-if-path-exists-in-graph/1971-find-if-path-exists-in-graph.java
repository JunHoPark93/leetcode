class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap();

        boolean[] isVisited = new boolean[n];

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            List aList = graph.getOrDefault(a, new ArrayList());
            aList.add(b);
            List bList = graph.getOrDefault(b, new ArrayList());
            bList.add(a);
            graph.put(a, aList);
            graph.put(b, bList);
        }

        return dfs(graph, isVisited, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] isVisited, int cur, int dest) {
        if (cur == dest) {
            return true;
        }

        if (isVisited[cur] == false) {
            isVisited[cur] = true;

            for (int node: graph.get(cur)) {
                if (dfs(graph, isVisited, node, dest)) {
                    return true;
                }
            }
        }
        return false;
    }
}