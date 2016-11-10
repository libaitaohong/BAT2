package binarySearch;

/**
 * 工程: BAT2 包名: binarySearch 类名: MinValue
 * 作者: zhanghe
 * 时间: 2016/11/10 10:44
 * 题目: 循环有序数组最小值
 * 内容:对于一个有序循环数组arr，返回arr中的最小值。有序循环数组是指，有序数组左边任意长度
 * 的部分放到右边去，右边的部分拿到左边来。比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 * 测试样例：[4,1,2,3,3],5  返回：1
 * 版本:
 * 运行时间:53 ms	843K
 * 备注:
 */
public class MinValue {
    public int getMin(int[] arr, int n) {
        if (n == 0) return -1;
        if (n == 1 || arr[0] < arr[n-1]) return arr[0];
        int resu = 0;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if (arr[mid] < arr[left]){
                right = mid-1;
                resu = mid;
            }else if (arr[mid] > arr[right]){
                left = mid + 1;
            }else{
                int res = left;
                while(left <= right){
                    if (arr[left] < arr[res])
                        res = left;
                    left++;
                }
                if (arr[res] <= arr[resu])
                    return arr[res];
            }
        }
        return arr[resu];
    }
}
