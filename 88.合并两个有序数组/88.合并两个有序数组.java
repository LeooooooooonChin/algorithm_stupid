import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {

    // 合并后排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // 双指针，从前往后
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while ((p1 < m) && (p2 < n)) {
            nums1[p3++] = (nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] :  nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    // 双指针，从后往前
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
// @lc code=end

