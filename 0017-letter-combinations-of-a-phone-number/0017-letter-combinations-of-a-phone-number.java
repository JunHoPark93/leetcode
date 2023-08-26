class Solution {
    List<String> answers = new ArrayList<>();
    static Map<Character, String> map = new HashMap<>();
    String digitsCopy;

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        // hashmap
        // check the digits length
        // iterate each elem
        // 
        digitsCopy = digits;
        

        int len = digits.length();

        // backtrack with index, result

        // if result.length == index -> put result into answers and finish
        // find values in the map with key(index)
        // iterate chars
        // // append result and call backtrack
        // // remove last chars
        if (len == 0) {
            return answers;
        }

        backtrack(0, new StringBuilder());
        return answers;
    }

    private void backtrack(int index, StringBuilder result) {
        if (result.length() == digitsCopy.length()) {
            answers.add(result.toString());
            return;
        }
        
        String targets = map.get(digitsCopy.charAt(index));
        for (char c : targets.toCharArray()) {
            result.append(c);
            backtrack(index + 1, result);
            result.deleteCharAt(result.length() - 1);
        }
    }
}   









