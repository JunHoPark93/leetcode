class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 최소, 최대 구하기
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] count = new int[max - min + 1];

        for (int num : nums) {
            count[num - min]++;
        }

        int remain = k;

        for (int i = count.length - 1; i >= 0; i--) {
            remain -= count[i];
            if (remain <= 0) {
                return i + min;
            }
        }

        return -1;

        // PriorityQueue<Integer> heap = new PriorityQueue<>();
        // for (int num : nums) {
        //     heap.add(num);
        //     if (heap.size() > k) {
        //         heap.remove();
        //     } 
        // }

        // return heap.peek();
    }
}