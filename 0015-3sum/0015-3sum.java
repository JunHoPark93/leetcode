class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // nums 를 정렬
        // 배열내 i를 순환하면서 두개의 합을 구하는 함수(sum)를 호출한다. 단 요소가 양수면 스킵한다. 양수면 sum함수내에서 음수를 만들 수 없다. 정렬이 되어있기 때문 

        // sum함수
        // low = i + 1, high = nums.length - 1
        // while low < high
        // nums[i] + nums[low] + nums[high] 를 sum
            // sum이 0이면 결과 리스트에 추가
                // low++, high--
                // 중복제거를 위해 증가된 nums[low]가 이전인 nums[low-1]와 다를때까지 low를 증가
            // sum > 0
                // high--
            // sum < 0
                // low++
        // 결과를 리턴
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                sum(nums, i, results);
            }
        }

        return results;
    }

    private void sum(int[] nums, int i, List<List<Integer>> results) {
        int low = i + 1;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if (sum == 0) {
                results.add(List.of(nums[i], nums[low], nums[high]));
                low++;
                high--;
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            } else if (sum > 0) {
                high--;
            } else {
                low++;
            }
        }
    }
}