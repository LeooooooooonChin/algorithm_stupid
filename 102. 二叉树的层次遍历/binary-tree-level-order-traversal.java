// 解法一
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if(root == null){
        return list;
    }
    // 使用队列实现数据存储和取出
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        int currentLevel = queue.size();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < currentLevel; i++){
            TreeNode currNode = queue.poll();
            list2.add(currNode.val);
            if(currNode.left != null){
                queue.add(currNode.left);
            }
            if(currNode.right != null){
                queue.add(currNode.right);
            }
        }
        list.add(list2);
    }
    
    return list;
}