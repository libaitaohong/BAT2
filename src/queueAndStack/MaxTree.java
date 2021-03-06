package queueAndStack;

import java.util.Stack;

/**
 * 工程: BAT2 包名: queueAndStack 类名: MaxTree
 * 作者: zhanghe
 * 时间: 2016/9/19 20:15
 * 题目:数组变树
 * 内容:对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，
 * 其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。
 * 现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中
 * 更小的一个。若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。
 * 给定一个无重复元素的数组A和它的大小n，请返回一个数组，
 * 其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
 * 测试样例：[3,1,4,2],4   返回：[2,0,-1,2]
 * 版本:2
 * 改动：之前用了2个for循环来分别求左边与右边第一个比当前位置大的数。
 * 但是：当压栈时，栈顶元素为左边第一个比他大的数，出栈时，等待压栈为右边第一个比他大数，用一次for循环即可。
 * 运行时间:143 ms	1989K
 * 备注:
*/
public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        Stack<Integer> max = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            while(!max.empty() && A[i] > A[max.peek()]) {
                if (arr[max.peek()] == -1)
                    arr[max.peek()] = i;
                else if (A[arr[max.peek()]] > A[i])
                    arr[max.peek()] = i;
                max.pop();
            }
            if (max.empty()){
                arr[i] = -1;
            } else {
                arr[i] = max.peek();
            }
            max.push(i);
        }
    return arr;
    }
}
