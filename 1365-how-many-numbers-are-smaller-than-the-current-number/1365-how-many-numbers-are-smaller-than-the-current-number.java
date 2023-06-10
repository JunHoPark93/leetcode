class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // define result array
        // loop nums from 0~nums.size
        // compare others -> count -> put into array

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (target > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}