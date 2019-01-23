// 解法一 136ms
class KthLargest {

    PriorityQueue<Integer> priorityQueue;
    int size;
    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue(k);
        size = k;
        if(nums == null){
            nums = new int[0];
        }
        for(int val : nums){
            add(val);
        }
    }
    
    public int add(int val) {
        if(priorityQueue.size() < size){
            priorityQueue.offer(val);
        }else if(priorityQueue.peek() < val){
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */