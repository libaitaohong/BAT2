package binarySearch;

/**
 * 工程: BAT2 包名: binarySearch 类名: LeftMostAppearance
 * 作者: zhanghe
 * 时间: 2016/11/9 21:13
 * 题目:元素最左出现
 * 内容:对于一个有序数组arr，再给定一个整数num，请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。请返回所求位置。若该元素在数组中未出现，请返回-1。
 * 测试样例：[1,2,3,3,4],5,3  返回：2
 * 版本:2
 * 运行时间:57 ms	964K
 * 备注:设定res，将等于num的下标存入，当left>right时跳出循环，返回res
 */
public class LeftMostAppearance {
    public int findPos(int[] arr, int n, int num) {
        if (n <=0)
            return -1;
        int res = -1;
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (arr[mid] > num){
                right = mid - 1;
            }else if(arr[mid] < num)
                left = mid + 1;
            else{
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
