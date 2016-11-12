package binarySearch;

/**
 * 工程: BAT2 包名: binarySearch 类名: CountNodes
 * 作者: zhanghe
 * 时间: 2016/11/12 10:46
 * 题目:完全二叉树计数
 * 内容:给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，
 * 请实现时间复杂度低于O(N)的解法。给定树的根结点root，请返回树的大小。
 * 版本:
 * 运行时间:111 ms	2920K
 * 备注:注意公式细节，以及根节点在什么地方加上。
 */
public class CountNodes {
    public int count(TreeNode root) {
        if (root == null) return -1;
        TreeNode cur = root;
        int count = 0;
        while (cur != null){
            int hleft = 0;
            int hright = 0;
            if (cur.left != null){//根节点左子树最左叶子的高度,最小为0，没有子树时
                TreeNode left = cur.left;
                hleft = getH(left) + 1;
            }
            if (cur.right != null){
                TreeNode right = cur.right;
                hright = getH(right) + 1; //根节点右子树最左叶子的高度
            }
            if (hleft == 0){
                count += 1;
                break;
            }else if (hright == 0){
                count += 2;
                break;
            }else if (hleft == hright){ //求左子树加根节点的个数
                count += Math.pow(2,hleft-1);
                cur = cur.right;
            }else if (hleft > hright){
                count += Math.pow(2,hright-1);
                cur = cur.left;
            }

        }
        return count;
    }
    private int getH(TreeNode cur){
        int h = 1; //树的高度
        while(cur.left != null){
            h++;
            cur = cur.left;
        }
        return h;
    }
}
