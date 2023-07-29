class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> map = new HashMap<>();

        for (String feature : features) {
            map.put(feature, 0);
        }

        for (String response : responses) {
            String[] responseArr = response.split(" ");

            record(map, responseArr);
        }

        // sort
        Arrays.sort(features, (o1, o2) -> map.get(o2) - map.get(o1));

        return features;
    }

    private void record(Map<String, Integer> map, String[] responseArr) {
        Set<String> visited = new HashSet();
        for (String response : responseArr) {
            if (map.containsKey(response) && !visited.contains(response)) {
                map.put(response, map.get(response) + 1);
                visited.add(response);
            }
        }
    }
}