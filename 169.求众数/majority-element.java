// 解法一
public int majorityElement(int[] nums) {
    int sss = nums[0];
    int count = 1;
    for(int i = 1; i < nums.length; i++) {
        if(count == 0) {
            count++;
            sss = nums[i];
        }else if(nums[i] == sss) {
            count++;
        }else {
            count--;
        }
    }
    return sss;
}
// 解法二
public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}