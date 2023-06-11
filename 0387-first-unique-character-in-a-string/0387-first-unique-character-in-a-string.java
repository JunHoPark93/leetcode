class Solution {
    public int firstUniqChar(String s) {
        // map
        Map<Character, Integer> count = new LinkedHashMap();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        // find first value that has 1

        Map.Entry<Character, Integer> characterIntegerEntry = count.entrySet().stream().filter(v -> v.getValue() == 1)
                .findFirst()
                .orElse(null);

        if (characterIntegerEntry == null) {
            return -1;
        }   
        return s.indexOf(characterIntegerEntry.getKey());
    }
}