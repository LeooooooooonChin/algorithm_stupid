// 解法一 38ms
public int[] twoSum(int[] nums, int target) {
    int[] sign = new int[2];
    for(int i = 0; i < nums.length-1; i++){
        for(int j = i+1; j < nums.length; j++){
            int sum = nums[i] + nums[j];
            if(sum == target){
                sign[0] = i;
                sign[1] = j;
                break;
            }
        }
    }
    return sign;
}
// 解法二 6ms
public int[] twoSum(int[] nums, int target) {
    int[] sign = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    for(int i = 0; i < nums.length; i++){
        if(map.containsKey(nums[i])){
            sign[0] = map.get(nums[i]);
            sign[1] = i;
            return sign;
        }
        map.put(target - nums[i], i);
    }
    return sign;
}