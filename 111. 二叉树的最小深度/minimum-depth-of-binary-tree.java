// 解法一 分治
public int minDepth(TreeNode root) {
    if(root == null){
        return 0;
    }
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    if(left == 0 && right == 0){
        return 1;
    }else if(left == 0){
        left = right;
    }else if(right == 0){
        right = left;
    }
    return Math.min(left, right) + 1;
}
// 解法一 代码精简版分治
public int minDepth(TreeNode root) {
    if(root == null){
        return 0;
    }
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
}