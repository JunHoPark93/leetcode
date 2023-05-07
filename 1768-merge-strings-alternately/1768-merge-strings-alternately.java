class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int w1Len = word1.length();
        int w2Len = word2.length();

        for (int i = 0; i < word1.length(); i++) {
            if (i >= w2Len) {
                sb.append(word1.substring(i, word1.length()));
                break;
            }
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if (w1Len < w2Len) {
            sb.append(word2.substring(w1Len, word2.length()));
        }

        return sb.toString();
    }
}