// 解法一 1ms
private List<Integer> list = new LinkedList<Integer>();
    
public List<Integer> inorderTraversal(TreeNode root) {
    pre(root);
    return list;
}

public void pre(TreeNode root){
    if(root != null){
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}