import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> list = new LinkedList<>();

    // 递归
    public List<Integer> preorder(Node root) {
        dfs(root);
        return list;
    }

    public void dfs(Node root) {
        if (root == null) return;
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i));
        }
    }

    // 迭代
    public List<Integer> preorder(Node root) {
        if (root == null) return new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}
// @lc code=end

