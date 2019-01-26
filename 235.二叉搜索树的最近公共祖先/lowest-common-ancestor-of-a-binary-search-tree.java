//思路：第一个大于p.data并且小于q.data的结点就是他们的最近公共祖先；
//若当前节点值小于p.data，则最近公共祖先在其右子树中；
//若当前节点值大于q.data,则最近公共祖先在其左子树中；
// 解法一 非递归 19 ms
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
        return root;
    }
    if(root == p || root == q) {
        return root;
    }
    while (root != null) {
        if(p.val < root.val && root.val > q.val){
            root = root.left;
        }else if(p.val > root.val && root.val < q.val){
            root = root.right;
        }else {
            break;
        }
    }
    return root;
}
// 解法二 22 ms
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(p.val < root.val && q.val < root.val) {
        return lowestCommonAncestor(root.left, p, q);
    }else if(p.val > root.val && q.val > root.val){
        return lowestCommonAncestor(root.right, p, q);
    }
    return root;
}