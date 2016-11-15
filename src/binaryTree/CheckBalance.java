package binaryTree;

/**
 * 工程: BAT2 包名: binaryTree 类名: CheckBalance
 * 作者: zhanghe
 * 时间: 2016/11/15 19:29
 * 题目:平衡二叉树判断
 * 内容:有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根结点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 * 版本:
 * 运行时间:68 ms	1282K
 * 备注:递归函数返回每个节点的高度
 */
public class CheckBalance {
    public boolean check(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHight(root, 1, res);
        return res[0];
    }

    private int getHight(TreeNode root, int level, boolean[] res){
        if (root == null)
            return level;
        int lh = getHight(root.left, level + 1, res);
        if (!res[0])
            return level;
        int rh = getHight(root.right, level + 1, res);
        if (!res[0])
            return level;
        if (Math.abs(lh - rh) > 1)
            res[0] = false;
        return Math.max(lh,rh);
    }
}
