package binarySearch;

/**
 * 工程: BAT2 包名: binarySearch 类名: LeftMostAppearance
 * 作者: zhanghe
 * 时间: 2016/11/9 21:13
 * 题目:元素最左出现
 * 内容:对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * 测试样例：[1,2,3,3,4],5,3  返回：2
 * 版本:1
 * 运行时间:66 ms	984K
 * 备注:将最后左、右、中间定为一个数，返回该数
 */
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        if (n <=0)
            return -1;
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (arr[mid] >= num){
                right = mid;
            }else
                left = mid + 1;
            if (left == right){
                if (arr[mid] == num)
                    return mid;
            }
        }
        return -1;
    }
}
