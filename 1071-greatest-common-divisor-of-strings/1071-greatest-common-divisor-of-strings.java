class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String finalTarget = "";
        for (int i = 0; i <= str1.length(); i++) {
            String target = str1.substring(0, i);
            if (target.isEmpty()) {
                continue;
            }
            // check str1, str2 can divide into target with no remainder
            String str1Remainder = str1.replace(target, "");
            String str2Remainder = str2.replace(target, "");

            if (str1Remainder.isEmpty() && str2Remainder.isEmpty()) {
                finalTarget = target;
            }
        }
        return finalTarget;
    }
}