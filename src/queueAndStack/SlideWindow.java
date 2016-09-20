package queueAndStack;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 工程: BAT2 包名: queueAndStack 类名: SlideWindow
 * 作者: zhanghe
 * 时间: 2016/9/19 20:12
 * 题目:滑动窗口练习题
 * 内容:有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 * 测试样例：[4,3,5,4,3,3,6,7],8,3  返回：[5,5,5,4,6,7]
 * 版本:1
 * 运行时间:118 ms	1729K
 * 备注:
 */
public class SlideWindow {
    public int[] slide(int[] arr, int n, int w) {
        if (w >= n)
            return new int[]{-1};
        int[] res = new int[n-w+1];
        LinkedList<Integer> slip = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < n; i++){
            while(!slip.isEmpty() && arr[i] > arr[slip.peekLast()])
                slip.pollLast();
            slip.offerLast(i);
            if (slip.peekFirst() == i - w) {
                slip.pollFirst();
            }
            if (i >=w-1){
                res[j++] = arr[slip.peekFirst()];
            }
        }
        return res;
    }
}
