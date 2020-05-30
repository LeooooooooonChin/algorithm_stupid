// 递归
List<Integer> list = new ArrayList<>();

public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) return list;
    list.add(root.val);
    preorderTraversal(root.left);
    preorderTraversal(root.right);
    return list;
}

// 迭代
public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
        return output;
    }
    stack.add(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pollLast();
        output.add(node.val);
        if (node.right != null) {
            stack.add(node.right);
        }
        if (node.left != null) {
            stack.add(node.left);
        }
    }
    return output;
}