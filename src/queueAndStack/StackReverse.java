package queueAndStack;

import java.util.Stack;

/**
 * 工程: BAT2 包名: queueAndStack 类名: StackReverse
 * 作者: zhanghe
 * 时间: 2016/9/18 10:47
 * 题目:栈的反转
 * 内容:实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 * 版本:
 * 运行时间:184 ms,大小：5967K
 * 备注:
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        Stack<Integer> rstack = new Stack<>();
        for (int i = 0;i < n; i++){
            rstack.push(A[i]);
        }
        reverse(rstack);
        int i = n-1;
        while (!rstack.empty()){
            A[i] = rstack.pop();
            i--;
        }
        return A;
    }
    private int get(Stack<Integer> rstack){
        int result = rstack.pop();
        if (rstack.empty())
            return result;
        else {
            int last = get(rstack);
            rstack.push(result);
            return last;
        }
    }
    private void reverse(Stack<Integer> rstack){
        if (rstack.empty())
            return;
        int i = get(rstack);
        reverse(rstack);
        rstack.push(i);
    }
}
