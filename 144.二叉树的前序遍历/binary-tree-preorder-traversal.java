// 解法一 1ms
private List<Integer> list = new LinkedList<Integer>();

public List<Integer> preorderTraversal(TreeNode root) {
    pre(root);
    return list;
}

public void pre(TreeNode root){
    if(root != null){
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}