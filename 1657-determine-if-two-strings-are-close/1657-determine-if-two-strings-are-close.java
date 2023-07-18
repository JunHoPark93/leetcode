class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        // map -> key char, value count
        for (int i = 0; i < word1.length(); i++) {
            char target = word1.charAt(i);
            map1.put(target, map1.getOrDefault(target, 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            char target = word2.charAt(i);
            map2.put(target, map2.getOrDefault(target, 0) + 1);
        }

        // compare set is equal


        List<Integer> m1 = new ArrayList<>(map1.values());
        List<Integer> m1Sorted = m1.stream().sorted().collect(Collectors.toList());
        List<Integer> m2 = new ArrayList<>(map2.values());
        List<Integer> m2Sorted = m2.stream().sorted().collect(Collectors.toList());

        return m1Sorted.equals(m2Sorted) && map1.keySet().equals(map2.keySet());
    }
}