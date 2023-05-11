class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] arr = s.toCharArray();
        List<Character> targets = new ArrayList();
        
        // extract all vowels in correct order
        for (int i = 0; i < arr.length; i++) {
            if (vowels.contains(arr[i])) {
                targets.add(arr[i]);
            }
        }

        // reverse them (or put them in stack)
        Collections.reverse(targets);

        // Make StringBuilder
        StringBuilder sb = new StringBuilder();
        int count = 0;
        // loop from index 0 to length - 1
        for (int i = 0; i < arr.length; i++) {
            // check if vowel -> then get from reverse list from 0 index or pop from the stack
            if (vowels.contains(arr[i])) {
                sb.append(targets.get(count++));
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}