package binaryTree;

/**
 * 工程: BAT2 包名: binaryTree 类名: LongestDistance
 * 作者: zhanghe
 * 时间: 2016/11/19 20:11
 * 题目: 树上最远距离
 * 内容:从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，
 * 路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 * 版本:
 * 运行时间:62 ms	898K
 * 备注:
 */
public class LongestDistance {
    public int findLongest(TreeNode root) {
        int[] res = new int[1]; //记录距离当前根节点最长子树距离
        int max = findLongestCore(root, res);
        return max;
    }
    public int findLongestCore(TreeNode root, int[] res){
        if (root == null){
            res[0] = 0;
            return 0;
        }
        int lmax = findLongestCore(root.left, res);
        int maxLeft = res[0];
        int rmax = findLongestCore(root.right, res);
        int maxRight = res[0];
        res[0] = Math.max(maxLeft + 1, maxRight + 1);
        int max = Math.max(Math.max(lmax, rmax), maxLeft + maxRight + 1);
        return max;
    }

}

