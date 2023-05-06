class Solution {
    private Map<Integer, Integer> numByGroupValue = new HashMap();

    public int deleteAndEarn(int[] nums) {
        int maxValue = 0;
        // create map
        for (int i = 0; i < nums.length; i++) {
            numByGroupValue.put(nums[i], numByGroupValue.getOrDefault(nums[i], 0) + nums[i]);
        maxValue = Math.max(nums[i], maxValue);
        }

        int[] dp = new int[maxValue + 1];
        dp[0] = 0;
        dp[1] = numByGroupValue.getOrDefault(1, 0);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(numByGroupValue.getOrDefault(i, 0) + dp[i-2], dp[i-1]);
        }

        return dp[maxValue];
    }
}