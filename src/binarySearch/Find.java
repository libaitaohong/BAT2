package binarySearch;

import com.sun.org.apache.bcel.internal.generic.I2F;

/**
 * 工程: BAT2 包名: binarySearch 类名: Find
 * 作者: zhanghe
 * 时间: 2016/11/11 11:01
 * 题目:
 * 内容:有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
 * 如果所有位置上的数都不满足条件，返回-1。给定有序数组arr及它的大小n，请返回所求值。
 * 版本:
 * 测试样例：[-1,0,2,3],4  返回：2
 * 运行时间:52 ms	964K
 * 备注:
 */
public class Find {
    public int findPos(int[] arr, int n) {
        if (arr == null || n == 0) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = n-1;
        while (left <= right){
            if (arr[left] > left || arr[right] < right) {
                break;
            }
            int mid = left + (right - left)/2;
            if (arr[mid] > mid){
                right = mid - 1;
            }else if (arr[mid] < mid){
                left = mid + 1;
            }else{
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}
