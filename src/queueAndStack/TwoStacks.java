package queueAndStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 工程: BAT2 包名: queueAndStack 类名: TwoStacks
 * 作者: zhanghe
 * 时间: 2016/9/18 15:56
 * 题目:双栈排序
 * 内容:请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），
 * 要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 版本:
 * 运行时间:135 ms	3318K
 * 备注:
 */
public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> sort = new Stack<>();
        int i = 0;
        while (i < numbers.length){
            if (sort.empty() || numbers[i] <= sort.peek()) {
                sort.push(numbers[i]);
                i++;
            } else {
                numbers[i-1] = numbers[i];
                numbers[i] = sort.pop();
                i--;
            }
        }
        ArrayList<Integer> sss = new ArrayList<>();
        for (int j = numbers.length-1; j >= 0; j--){
            numbers[j] = sort.pop();
        }
        for (int j = 0; j < numbers.length; j++)
            sss.add(numbers[j]);
        return sss;
    }
}
