package binaryTree;

import java.util.Stack;

/**
 * 工程: BAT2 包名: binaryTree 类名: TreeToString
 * 作者: zhanghe
 * 时间: 2016/11/14 20:18
 * 题目:二叉树的序列化
 * 内容:首先我们介绍二叉树先序序列化的方式，假设序列化的结果字符串为str，初始时str等于空字符串。
 * 先序遍历二叉树，如果遇到空节点，就在str的末尾加上“#!”，“#”表示这个节点为空，节点值不存在，
 * 当然你也可以用其他的特殊字符，“!”表示一个值的结束。如果遇到不为空的节点，假设节点值为3，就在str的
 * 末尾加上“3!”。现在请你实现树的先序序列化。给定树的根结点root，请返回二叉树序列化后的字符串。
 * 版本:
 * 运行时间:140 ms	4060K
 * 备注:
 */
public class TreeToString {
    public String toString(TreeNode root) {
        String res = "";
        Stack<TreeNode> stack = new Stack<>();
        TreeNode none = null; //碰到空时将none压入栈中
        TreeNode cur = root;
        stack.add(root);
        while(!stack.empty()){
            cur = stack.pop();
            if (cur != none){
                res += cur.val + "!";
            }else{
                res += "#!";
            }
            if (cur != none && cur.right != null)
                stack.add(cur.right);
            else if (cur != none)
                stack.add(none);
            if (cur != none && cur.left != null)
                stack.add(cur.left);
            else if (cur != none)
                stack.add(none);
        }
        return res;
    }
}
