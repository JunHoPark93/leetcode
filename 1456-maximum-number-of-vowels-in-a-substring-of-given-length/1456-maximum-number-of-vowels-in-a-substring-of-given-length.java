class Solution {
    public int maxVowels(String s, int k) {
        // vowel set

        // s's size -> len
        // 0 ~ len - k
        // find max number of vowels

        int count = 0;

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int size = s.length();

        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                count++;
            }
        }

        int max = count;
        int current = count;
        for (int i = k; i < size; i++) {
            if (vowels.contains(s.charAt(i))) {
                current++;
            }
            if (vowels.contains(s.charAt(i-k))) {
                current--;
            }

            max = Math.max(max, current);
        }
        return max;
    }
}