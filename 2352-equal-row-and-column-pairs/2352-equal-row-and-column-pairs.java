class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rMap = new HashMap<>();
        Map<String, Integer> cMap = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            List<String> elems = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                elems.add(""+grid[i][j]);
            }
            String s = String.join("-", elems);

            rMap.put(s, rMap.getOrDefault(s, 0) + 1);
        }

        for (int i = 0; i < grid[0].length; i++) {
            List<String> elems = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                elems.add(""+grid[j][i]);
            }
            String s = String.join("-", elems);

            cMap.put(s, cMap.getOrDefault(s, 0) + 1);
        }

        int count = 0;

        for (String s : rMap.keySet()) {
            if (cMap.containsKey(s)) {
                count += cMap.get(s) * rMap.get(s);
            }
        }
        return count;
    }
}