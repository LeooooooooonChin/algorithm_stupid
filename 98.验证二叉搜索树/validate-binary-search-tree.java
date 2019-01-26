public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null,null);
}

private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
    if (root==null) {
        return true;
    }
    if (min!=null && root.val<=min.val || max!=null && root.val>=max.val) {
        return false;
    }

    return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
}