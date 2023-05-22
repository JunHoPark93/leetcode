class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }

        while (i < nums.length) {
            nums[i++] = 0;
        }

        // // count the number of zeros
        // int zeroCount = 0;
        // int len = nums.length;

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         zeroCount++;
        //     }
        // }

        // int[] result = new int[nums.length];
        // // loop nums array -> move elements without zero
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         continue;
        //     }
        //     result[i] = nums[i];
        // } 

        // int nonZeroEndIndex = len - zeroCount;
        // // append zeros as many time as the count of zeros
        // for (int i = 0; i < zeroCount; i++) {
        //     result[nonZeroEndIndex++] = 0;
        // } 
        
        // return result;
    }
}