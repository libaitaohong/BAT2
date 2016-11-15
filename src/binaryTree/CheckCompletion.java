package binaryTree;

import java.util.LinkedList;

/**
 * 工程: BAT2 包名: binaryTree 类名: CheckCompletion
 * 作者: zhanghe
 * 时间: 2016/11/15 19:57
 * 题目:完全二叉树判断
 * 内容:有一棵二叉树,请设计一个算法判断它是否是完全二叉树。
 * 给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
 * 版本:
 * 运行时间:73 ms	1420K
 * 备注:
 */
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        LinkedList<TreeNode> link = new LinkedList<>();
        TreeNode cur = root;
        link.add(root);
        int mark = 0;
        while(!link.isEmpty()){
            cur = link.pop();
            if (cur.left == null && cur.right != null)
                return false;
            if (cur.left != null && mark == 0)
                link.add(cur.left);
            else if (cur.left != null && mark != 0)
                return false;
            if (cur.right != null && mark == 0)
                link.add(cur.right);
            else if (cur.right != null && mark != 0)
                return false;
            if ((cur.left != null && cur.right == null) || (cur.left == null && cur.right == null))
                mark = 1;
        }
        return true;
    }
}
