package binaryTree;

import java.util.LinkedList;

/**
 * 工程: BAT2 包名: binaryTree 类名: TreePrinter
 * 作者: zhanghe
 * 时间: 2016/11/14 17:31
 * 题目:二叉树的打印
 * 内容:有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。给定二叉树的根结点root，请返回打印结果，
 * 结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，
 * 且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 * 版本:
 * 运行时间:41 ms	709K
 * 备注:注意linkedlist.pop()的值是变化的，使用要小心！！！！
 */
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        LinkedList<TreeNode> line = new LinkedList<>();
        LinkedList<Integer> number = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>(); //记录每行有多少个节点
        TreeNode last = root;
        TreeNode nlast = null;
        line.add(root);
        int k = 0;
        while(!line.isEmpty()){
            if (line.peek().left != null){
                line.add(line.peek().left);
                nlast = line.peek().left;
            }
            if (line.peek().right != null){
                line.add(line.peek().right);
                nlast = line.peek().right;
            }
            k++; //计数，弹出的个数，代表每行有多少节点
            number.add(line.peek().val);
            if (last == line.pop()){
                last = nlast;
                num.add(k);
                k = 0;
            }
        }
        int i = num.size();
        int[][] res = new int[i][];
        for (int row = 0; row < i; row++){
            int pop = num.pop();
            res[row] = new int[pop];
            for (int column = 0; column < pop; column++){
                res[row][column] = number.pop();
            }
        }
        return res;
    }
}
