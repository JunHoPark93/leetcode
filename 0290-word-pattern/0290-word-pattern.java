class Solution {
    public boolean wordPattern(String pattern, String s) {
        // record word with index number both pattern and s -> map
        String[] words = s.split(" ");

        Map charByIndex = new HashMap();

        if (words.length != pattern.length()) {
            return false;
        }

        for (Integer i = 0; i < words.length; i++) {
            char pChar = pattern.charAt(i);
            String wChar = words[i];

            if (!charByIndex.containsKey(pChar)) {
                charByIndex.put(pChar, i);
            }

            if (!charByIndex.containsKey(wChar)) {
                charByIndex.put(wChar, i);
            }

            // compare each index that both are same
            if (charByIndex.get(pChar) != charByIndex.get(wChar)) {
                return false;
            }
        }
        return true;
    }
}