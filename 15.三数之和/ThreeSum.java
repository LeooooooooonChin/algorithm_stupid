// 解法一 58ms
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length < 3) {
        return res;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int left = i + 1;
        int right = nums.length - 1;
        // a+b+c=0  可得 c=-(a+b)  target=-(left+right)=0
        int target = -nums[i];
        while(left < right){
            if(nums[left] + nums[right] == target){
                // 得到要需要的结果放入集合
                List<Integer> arr = new ArrayList<>();
                arr.add(-target);
                arr.add(nums[left]);
                arr.add(nums[right]);
                res.add(arr);
                // 添加完元素，移动下标寻找下一组解
                left++;
                right--;
                // ++后将要循环元素和上一个元素相同说明是相同解，a+?+c=0确定a,c的情况b只有一个值
                while(left < right && nums[left] == nums[left - 1]){
                    left++;
                }
                // ++后将要循环元素和上一个元素相同说明是相同解，a+b+?=0确定a,b的情况c只有一个值
                while(right > left && nums[right] == nums[right + 1]){
                    right--;
                }
            }else if(nums[left] + nums[right] < target){// a+b小于目标值，下标向大值方向移动
                left++;
            }else{// a+b大于目标值，下标向小值方向移动
                right--;
            }
        }
    }
    return res;
}