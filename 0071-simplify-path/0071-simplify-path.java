class Solution {
    public String simplifyPath(String path) {
        // '/' 기준으로 split 해서 리스트에 담고
        // 리스트를 순회하면서 각 요소를 stack에 넣는다.
            // '/' -> skip
            // '문자열' -> push
            // '.' -> skip
            // '..' -> stack이 비어있지 않다면 pop
        // stack요소들을 '/'로 구분해서 String 생성 (prefix에 '/'필요)

        String[] splitted = path.split("/");
        Stack<String> elems = new Stack<>();
        for (String s : splitted) {
            if (s.equals("/") || s.equals(".") || s.isEmpty()) {
                continue;
            }
            if (s.equals("..")) {
                if (!elems.isEmpty()) {
                    elems.pop();
                }
                continue;
            }

            elems.push(s);
        }

        if (elems.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!elems.isEmpty()) {
            String s = elems.pop();
            sb.insert(0, "/" + s);
        }
        return sb.toString();
    }
}