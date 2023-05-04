class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        val result = IntArray(2)
        for (i in nums.indices) {
            val num: Int = nums[i]
            val t = target - num
            map[t]?.let {
                return intArrayOf(it, i)
            }
            map[num] = i
        }
        return result
    }
}