class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        // st  0 1 
        // sw  1 0 1
        // calculate total loop n!
        int stLen = students.length;
        int swLen = sandwiches.length;
        int total = stLen * swLen;
        // for (int i = len; i > 0; i--) {
        //     total = total * i;
        // }

        List<Integer> st = Arrays.stream(students)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> sw = Arrays.stream(sandwiches)
            .boxed()
            .collect(Collectors.toList());

        // loop 
        for (int i = 0; i < total; i++) {
            if (st.isEmpty()) {
                break;
            }
            
            int stTarget = st.get(0);
            int swTarget = sw.get(0);

            if (stTarget == swTarget) {
                st.remove(0);
                sw.remove(0);
            } else {
                int removed = st.remove(0);
                st.add(removed);
            }
        }
        return st.size();
        // if first index matches together -> remove both first index
        // if not loop st list
        // until loop ends
    }
}