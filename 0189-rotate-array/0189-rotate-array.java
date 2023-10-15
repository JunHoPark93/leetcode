class Solution {
    public void rotate(int[] nums, int k) {
        // 끝에 k를 잘라서 앞에다가 붙이고 나머지 덩어리를 뒤에다가 붙인다.

        if (k == 0) {
            return;
        }

        if (nums.length == 1) {
            return;
        }

        int len = nums.length;

        while (k > len) {
            k = k - len;
        }
    
        int[] temp = new int[nums.length];

        int index = 0;
        for (int i = len - k; i <= len - 1; i++) {
            temp[index++] = nums[i];
        }

        for (int i = 0; i <= len - k - 1; i++) {
            temp[index++] = nums[i];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        // // 한칸씩 밀면서 끝에 도달하면 처음 인덱스로 돌려주기
        //     // 를 k번 반복

        // if (k == 0) {
        //     return;
        // }

        // int[] temp = move(nums);
        // k--;

        // while (k > 0) {
        //     temp = move(temp);
        //     k--;
        // }
        
        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = temp[i];
        // }
    }

    // private int[] move(int[] nums) {
    //     int[] temp = new int[nums.length];
    //     for (int i = 0; i < nums.length; i++) {
    //         if (i == nums.length - 1) {
    //             temp[0] = nums[nums.length - 1];
    //             continue;
    //         }
    //         temp[i+1] = nums[i];
    //     }
    //     return temp;
    // }
}