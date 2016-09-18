package queueAndStack;

import java.util.Stack;

/**
 * 工程: BAT2 包名: queueAndStack 类名: TwoStack
 * 作者: zhanghe
 * 时间: 2016/9/17 10:34
 * 题目:双栈队列练习题
 * 内容:编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，
 * 为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * 测试样例：[1,2,3,0,4,0],6  返回：[1,2]
 * 将数组看做队列，正数进队列，0出队列，先进后出，2个0，所以返回[1,2]
 * 版本:1
 * 运行时间:81 ms,大小：1286K
 * 备注:
 **/
public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
        Stack<Integer> stackpull = new Stack<>();
        Stack<Integer> stackpop = new Stack<>();
        int count = 0;
        for (int i = 0; i < n; i++){
            if (ope[i] != 0)
                stackpull.push(ope[i]);
            else
                count++;
        }
        while (!stackpull.empty()){
            stackpop.push(stackpull.pop());
        }
        int i = 0;
        int[] ope1 = new int[count];
        while(count > 0){
            ope1[i] = stackpop.pop();
            count--;
            i++;
        }
        return ope1;
    }
}
