class Solution {
    public boolean backspaceCompare(String s, String t) {
        // sStack push elements from s
        // tStack push elemtns from t
        Stack<Character> sStack = new Stack();
        Stack<Character> tStack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            sStack.push(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            tStack.push(t.charAt(i));
        }

        // sStack pop
        int count = 0;
        StringBuilder sString = new StringBuilder();
        while (!sStack.isEmpty()) {
            // if target '#' pop again
            // it target not '#' append String 
            Character target = sStack.pop();
            if (target == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                    continue;
                }
                sString.append(target);
            }
        }

        int count2= 0 ;
        StringBuilder tString = new StringBuilder();
        while (!tStack.isEmpty()) {
            // if target '#' pop again
            // it target not '#' append String 
            Character target = tStack.pop();
            if (target == '#') {
                count2++;
            } else {
                if (count2 > 0) {
                    count2--;
                    continue;
                }
                tString.append(target);
            }
        }

        return sString.toString().equals(tString.toString());
    }
}