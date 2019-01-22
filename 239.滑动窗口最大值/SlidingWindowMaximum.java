// 解法一
public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length < 1 || k < 1) {
        return new int[0];
    }
    // 源数据长度
    int n = nums.length;
    // 装结果的数组
    int[] res = new int[n-k+1];
    // 计数器
    int count = 0;
    Deque<Integer> q = new ArrayDeque<>();
    // 遍历所有元素
    for (int i = 0; i < nums.length; i++) {
        // ([1,2,3],4)...(1,[2,3,4])
        // (i - k + 1)###计算滑动窗口应该进入双端队列的第一个位置的的元素下标###
        // 只做滑动窗口的位移，双端队列的第一个下标如果小于(i - k + 1)
        while (!q.isEmpty() && q.peek() < i - k + 1) {
            // 就移除队双端队列中的第一个元素下标
            q.poll();
        }
        // 从队列的最后开始遍历，如果小于即将要进入队列的元素比较
        while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
            // 如果元素比即将进入数组的元素小，就移除队列中的最后一个元素（因为老元素生命周期比他短并且还比他小）
            q.pollLast();
        }
        // 往队列中添加元素索引
        q.offer(i);
        // 避免在数组元素小于k个的时候插入最大值，数组装满k个之前不符合要求
        if (i >= k - 1) {
            res[count++] = nums[q.peek()];
        }
    }
    return res;
}