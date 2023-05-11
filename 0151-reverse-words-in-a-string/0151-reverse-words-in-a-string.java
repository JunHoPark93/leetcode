class Solution {
    public String reverseWords(String s) {
        // seperate words from the input 
        // check every index if black exists and extract word
        List<String> targets = new ArrayList();

        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        // add to targets in order
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                sb.append(arr[i]);
            }
            if (arr[i] == ' ' || i == arr.length - 1) {
                if (!sb.toString().isEmpty()) {
                    targets.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }

        // reverse the targets
        Collections.reverse(targets);
        return targets.stream().collect(Collectors.joining(" "));
    }
}