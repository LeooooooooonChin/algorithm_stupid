// 解法一 分治
public int maxDepth(TreeNode root) {
    if(root == null){
        return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    if(left == 0 && right == 0){
        return 1;
    }else if(left == 0){
        left = right;
    }else if(right == 0){
        right = left;
    }
    return Math.max(left, right) + 1;
}

// 解法二 代码精简版分治
public int maxDepth(TreeNode root) {
    return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}