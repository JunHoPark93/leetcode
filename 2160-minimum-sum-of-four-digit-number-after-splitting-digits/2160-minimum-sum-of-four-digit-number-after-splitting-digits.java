class Solution {
    public int minimumSum(int num) {
        String n = String.valueOf(num);
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < n.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(n.charAt(i))));
        }
        Collections.sort(list);

        int candidate1 = list.get(0) * 10 + list.get(1) + list.get(2) * 10 + list.get(3);
        int candidate2 = list.get(0) * 10 + list.get(2) + list.get(1) * 10 + list.get(3);

        return candidate1 < candidate2 ? candidate1 : candidate2;
    }
}