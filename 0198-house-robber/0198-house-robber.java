class Solution {
    private Map<Integer, Integer> memo = new HashMap();
    private int[] nums;
    
    public int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length - 1);
    }
    
    private int dp(int n) {
        // base case
        if (n == 0) {
            memo.put(0, nums[0]);
            return nums[0];
        }
        if (n == 1) {
            memo.put(1, Math.max(nums[0], nums[1]));
            return Math.max(nums[0], nums[1]);
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }    
        
        memo.put(n, Math.max(dp(n-1), dp(n-2) + nums[n]));
        
        return memo.get(n);
    }
}