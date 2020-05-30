/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 * [1,2,2,3,3]
 */
// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
// @lc code=end

