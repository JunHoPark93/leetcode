class Solution {
    public int[] sortArray(int[] nums) {
        //quickSort(0, nums.length - 1, nums);

        mergeSort(nums);

        return nums;
    }

    private void mergeSort(int[] nums) {
        // 반으로 나누기
        int len = nums.length;

        if (len < 2) {
            return;
        }

        int mid = len / 2;

        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[len - mid];

        for (int i = 0; i < mid; i++) {
            leftHalf[i] = nums[i];
        }

        for (int j = mid; j < len; j++) {
            rightHalf[j - mid] = nums[j];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // 합치기
        merge(leftHalf, rightHalf, nums);
    }

    private void merge(int[] leftHalf, int[] rightHalf, int[] nums) {
        // leftHalf & rightHalf is already sorted
        int lP = 0;
        int rP = 0;
        int numP = 0;

        while (lP < leftHalf.length && rP < rightHalf.length) {
            if (leftHalf[lP] < rightHalf[rP]) {
                nums[numP] = leftHalf[lP];
                numP++;
                lP++;
            } else {
                nums[numP] = rightHalf[rP];
                numP++;
                rP++;
            }
        }

        while (lP < leftHalf.length) {
            nums[numP] = leftHalf[lP];
            lP++;
            numP++;
        }

        while (rP < rightHalf.length) {
            nums[numP] = rightHalf[rP];
            rP++;
            numP++;
        }
    }

    // # Quick Sort
    // private void quickSort(int start, int end, int[] nums) {
    //     if (start >= end){
    //         return;
    //     }
    //     int pivot = nums[end];
    //     int lP = start;
    //     int rP = end;

    //     while (lP < rP) {
    //         while (nums[lP] <= pivot && lP < rP) {
    //             lP++;
    //         }
    //         while (nums[rP] >= pivot && lP < rP) {
    //             rP--;
    //         }
    //         swap(nums, lP, rP);
    //     }
        
    //     swap(nums, lP, end);

    //     quickSort(start, lP - 1, nums);
    //     quickSort(lP + 1, end, nums); 
    // }

    // private void swap(int[] nums, int i1, int i2) {
    //     int temp = nums[i1];
    //     nums[i1] = nums[i2];
    //     nums[i2] = temp;
    // }
}