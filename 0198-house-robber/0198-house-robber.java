class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        
        // base case
        dp[0] = nums[0];
        if (size == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < size; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[size-1];
    }
}