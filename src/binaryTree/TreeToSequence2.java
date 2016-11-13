package binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 工程: BAT2 包名: binaryTree 类名: TreeToSequence2
 * 作者: zhanghe
 * 时间: 2016/11/13 18:19
 * 题目:非递归二叉树的序列打印
 * 内容:请用非递归方式实现二叉树的先序、中序和后序的遍历打印。
 * 给定一个二叉树的根结点root，请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 * 版本:
 * 运行时间:250 ms	174K
 * 备注:
 */
public class TreeToSequence2 {
    public int[][] convert1(TreeNode root) {
        LinkedList<Integer> pre = new LinkedList<>();
        LinkedList<Integer> in = new LinkedList<>();
        LinkedList<Integer> pos = new LinkedList<>();
        preOrderRecu(root, pre);
        inOrderRecu(root, in);
        posOrderRecu(root, pos);
        int[][] res = new int[3][];
        int presize = pre.size();
        int insize = in.size();
        int possize = pos.size();
        res[0] = new int[presize];
        res[1] = new int[insize];
        res[2] = new int[possize];
        for (int i = 0; i < presize; i++){
            res[0][i] = pre.pop();
        }
        for (int j = 0; j < insize; j++){
            res[1][j] = in.pop();
        }
        for (int k = 0; k < possize; k++){
            res[2][k] = pos.pop();
        }
        return res;
    }
    private void preOrderRecu(TreeNode cur, LinkedList pre){
        Stack<TreeNode> spre = new Stack<>();
        spre.push(cur);
        while(!spre.empty()){
            cur = spre.peek();
            pre.add(spre.pop().val);
            if (cur.right != null)
                spre.push(cur.right);
            if (cur.left != null)
                spre.push(cur.left);
        }
    }
    private void inOrderRecu(TreeNode cur, LinkedList in){
        Stack<TreeNode> sin = new Stack<>();
        while (!sin.empty() || cur != null){
            if (cur == null){
                cur = sin.peek().right;
                in.add(sin.pop().val);
            }else{
                sin.push(cur);
                cur = cur.left;
            }
        }
    }
    private void posOrderRecu(TreeNode cur, LinkedList pos){
        Stack<TreeNode> spos = new Stack<>();
        spos.push(cur);
        TreeNode h = cur;
        TreeNode c = null;
        while(!spos.empty()){
            c = spos.peek();
            if (c.left != null && h != c.left && h != c.right){
                spos.push(c.left);
            }else if (c.right != null && h != c.right){
                spos.push(c.right);
            }else{
                h = c;
                pos.add(spos.pop().val);
            }
        }
    }
}
