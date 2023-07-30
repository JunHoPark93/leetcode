class Solution {
    public int lengthOfLongestSubstring(String s) {
        // iterate each char in s
        // check list contains s
        // // if contains -> 
        // // // find starting from the target
        // // if not contains -> append the list, record max length (result array)

        // return the max value of the result array
        int len = s.length();
        int[] result = new int[len];
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char target = s.charAt(i);
            if (list.contains(target)) {
                list = extractSubString(list, target);
            } 
            list.add(target);
            result[i] = list.size();
        }

        int max = 0;
        for (int i : result) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    private List<Character> extractSubString(List<Character> list, Character target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return list.subList(i + 1, list.size());
            }
        }
        // cannot be reached
        return list;
    }
}