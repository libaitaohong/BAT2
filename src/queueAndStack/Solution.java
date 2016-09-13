package queueAndStack;

import java.util.Stack;

/**
 * Created by zhanghe on 2016/9/13.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 35 ms	528K
 */
public class Solution {
    Stack<Integer> stackdata = new Stack<Integer>();
    Stack<Integer> stackmin = new Stack<Integer>();
    public void push(int node) {
        stackdata.push(node);
        if (stackmin.empty())
            stackmin.push(node);
        else if (stackmin.peek() >= node)
            stackmin.push(node);
        else
            stackmin.push(stackmin.peek());
    }

    public void pop() {
        stackdata.pop();
        stackmin.pop();
    }

    public int top() {
        return stackmin.peek();
    }

    public int min() {
        return stackmin.peek();
    }
}
