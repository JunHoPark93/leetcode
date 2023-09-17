class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    private void quickSort(int start, int end, int[] nums) {
        if (start >= end){
            return;
        }
        int pivot = nums[end];
        int lP = start;
        int rP = end;

        while (lP < rP) {
            while (nums[lP] <= pivot && lP < rP) {
                lP++;
            }
            while (nums[rP] >= pivot && lP < rP) {
                rP--;
            }
            swap(nums, lP, rP);
        }
        
        swap(nums, lP, end);

        quickSort(start, lP - 1, nums);
        quickSort(lP + 1, end, nums); 
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}