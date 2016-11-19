package binaryTree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 工程: BAT2 包名: binaryTree 类名: FindErrorNode
 * 作者: zhanghe
 * 时间: 2016/11/17 20:31
 * 题目:寻找错误结点
 * 内容:一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索
 * 二叉树，请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。给定一棵树的
 * 根结点，请返回两个调换了位置的值，其中小的值在前。
 * 版本:
 * 运行时间:62 ms	898K
 * 备注:
 */
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null){
            if (cur == null){
                cur = stack.peek().right;
                list.add(stack.pop().val);
            }else{
                stack.push(cur);
                cur = cur.left;
            }
        }
        LinkedList<Integer> count = new LinkedList<>();
        int k = list.size();
        for (int i = 0; i < k-1; i++){
            if (list.get(i) > list.get(i+1)){
                count.add(list.get(i));
                count.add(list.get(i+1));
            }
        }
        int[] res = new int[2];
        if (count.size() == 2){
            res[0] = count.get(1);
            res[1] = count.get(0);
        }else if (count.size() == 4){
            res[0]=  count.get(3);
            res[1]=  count.get(1);
        }
        return res;
    }
}
