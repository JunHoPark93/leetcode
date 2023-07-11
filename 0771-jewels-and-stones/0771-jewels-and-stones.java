class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // stones Map k: alphabet, v: count

        // loop all jewels
        // if stones exists -> subtract 1 value -> plus counts

        Map<Character, Integer> charByCount = new HashMap();

        for (int i = 0; i < stones.length(); i++) {
            char target = stones.charAt(i);
            charByCount.put(target, charByCount.getOrDefault(target, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            char target = jewels.charAt(i);
            Integer value = charByCount.get(target);
            if (value != null && value >= 0) {
                count = count + value;
            }
        }

        return count;
    }
}