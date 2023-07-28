class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // identify which group the word can belong to
        // 1. how to idenify?
        // 2. how to define a group?

        // bat -> group consist of letters in any order
        // (2) group -> the list of the letters (assume as a key)
        // // Map<List<Character>, List<String>> -> return the group values (<- answer)
        // (1) iterate the strs check each elem's letters are exactly matches the key 
        // // if matches -> add to the values
        // // if not mactches -> create new keys with value

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String elem = strs[i];

            upsert(map, elem);
        }

        // return values of the map
        return new ArrayList(map.values());
    }

    private void upsert(Map<String, List<String>> map, String elem) {
        char[] elems = elem.toCharArray();
        Arrays.sort(elems);
        String key = String.valueOf(elems);

        if (map.get(key) == null) {
            map.put(key, new ArrayList());
        }
        map.get(key).add(elem);
    }   
}