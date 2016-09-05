package string;

import java.util.ArrayList;

/**
 * Created by zhanghe on 2016/9/1.
 * 检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 首先将树序列化，并使用KMP算法判断一个字符串中是否包含另外一个
 * A和B是两棵树的头结点
 * 运行时间37ms，大小709k
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        ArrayList<String> treeA = new ArrayList<String>();
        ArrayList<String> treeB = new ArrayList<String>();
        //树变成数组列表
        if (A != null && B != null){
            treeToArray(A, treeA);
            treeToArray(B, treeB);
        }
        //数组列表转换为数组
        String[] strA = new String[treeA.size()];
        String[] strB = new String[treeB.size()];
        for (int i = 0,j = treeA.size(); i < j; i++ ){
            strA[i] = treeA.get(i);
        }
        for (int i = 0,j = treeB.size(); i < j; i++ ){
            strB[i] = treeB.get(i);
        }
       ///构建next数组
        int[] next = getNextArray(strB);
        //匹配
        int ai = 0; //ai bi对应strA与strB当前位置
        int bi = 0;
        while (ai < strA.length && bi < strB.length){
            if (strA[ai].equals(strB[bi])){
                ai++;
                bi++;
            }else if (next[bi] >= 0){
                bi = next[bi];
            }else{
                ai++;
            }
        }
        if (bi == strB.length){
            return true;
        }
        return false;
    }
    //递归调用将树变成数组列表，采用中序遍历
    private void treeToArray(TreeNode t,  ArrayList<String> a){
        String val = t.val + "";
        a.add(val);
        if (t.left != null){
            treeToArray(t.left, a);
        }else{
            a.add("#");
        }
        if (t.right != null){
            treeToArray(t.right, a);
        }else{
            a.add("#");
        }
    }

    private int[] getNextArray(String[] strB){
        if (strB.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[strB.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2; //当前需要计算值的位置
        int cn = 0; //cn是pos前一个位置的最长相同前缀的后一位
        while(pos < strB.length){ //注意下标与长度的关系，最多到length-1
            if (next[pos] == cn){
                next[pos++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }
        return next;
    }
}
