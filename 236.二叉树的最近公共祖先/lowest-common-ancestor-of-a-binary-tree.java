// 解法一 16 ms
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q){
        return root;
    }

    TreeNode right = lowestCommonAncestor(root.right, p, q);
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    if(left == null && right == null){
        return null;
    }
    if(left != null && right != null){
        return root;
    }
    if(left == null && right != null){
        return right;
    }
    if(right == null && left != null){
        return left;
    }
    return null;
}
// 解法一 33ms
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q){
        return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    return left == null ? right : right == null ? left : root;
}
