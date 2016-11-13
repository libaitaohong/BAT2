package binaryTree;

import java.util.LinkedList;

/**
 * 工程: BAT2 包名: binaryTree 类名: TreeToSequence
 * 作者: zhanghe
 * 时间: 2016/11/13 15:25
 * 题目:递归二叉树的序列打印
 * 内容:请用递归方式实现二叉树的先序、中序和后序的遍历打印。给定一个二叉树的根结点root，
 * 请依次返回二叉树的先序，中序和后续遍历(二维数组的形式)。
 * 版本:
 * 运行时间:232 ms	290K
 * 备注:注意链表的长度，pop后长度会随之改变！！！
 */
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
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
    private void preOrderRecu(TreeNode root, LinkedList pre){
        if (root == null)
            return;
        pre.add(root.val);
        preOrderRecu(root.left, pre);
        preOrderRecu(root.right,pre);
    }
    private void inOrderRecu(TreeNode root, LinkedList in){
        if (root == null)
            return;
        inOrderRecu(root.left, in);
        in.add(root.val);
        inOrderRecu(root.right,in);
    }
    private void posOrderRecu(TreeNode root, LinkedList pos){
            if (root == null)
            return;
        posOrderRecu(root.left, pos);
        posOrderRecu(root.right,pos);
        pos.add(root.val);
    }
}
