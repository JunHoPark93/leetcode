class Solution {
    public int romanToInt(String s) {
        // subtract or add

        // map of symbol

        // loop 0 ~ s size

        // if (big -> small) -> add
        // if ()

        // M C M X C I V
        // if subtract candidates 
        // // check right is bigger than current -> - current
        // // check right is smaller than current -> + current

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        // M DCCCC LXXXX IIII
        // 1000 500 + 400 50 + 40 + 4
        // 1900 + 90 + 4
        // MDCCCCLXXXXIIII
        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");

        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char curC = s.charAt(i);
            sum += map.get(curC);
        }

        return sum;
    }
}