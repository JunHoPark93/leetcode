class Solution {
    public int numIdenticalPairs(int[] nums) {
        // 
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (first == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}