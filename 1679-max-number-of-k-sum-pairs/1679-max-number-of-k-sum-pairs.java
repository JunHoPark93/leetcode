class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> numByCount = new HashMap<>();

        for (int num : nums) {
            numByCount.put(num, numByCount.getOrDefault(num, 0) + 1);
        }
        int count = 0;

        for (int current : nums) {
            int target = k - current;

            if (numByCount.getOrDefault(target, 0) > 0 && numByCount.getOrDefault(current, 0) > 0) {
                // key 하나 감소 , target 하나 감소
                if (target == current) {
                    if (numByCount.get(target) < 2) {
                        continue;
                    }
                }
                numByCount.put(current, numByCount.get(current) - 1);
                numByCount.put(target, numByCount.get(target) - 1);
                count++;
            }
        }

        return count;
    }
}