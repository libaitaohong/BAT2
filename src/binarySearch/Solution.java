package binarySearch;

/**
 * 工程: BAT2 包名: binarySearch 类名: Solution
 * 作者: zhanghe
 * 时间: 2016/11/9 19:36
 * 题目:局部最小值位置
 * 内容:定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，
 * 如果arr[0]<arr[1]，那么arr[0]是局部最小；如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；
 * 如果0<i<N-1，既有arr[i]<arr[i-1]又有arr[i]<arr[i+1]，那么arr[i]是局部最小。给定无序数组arr，
 * 已知arr中任意两个相邻的数都不相等，写一个函数，只需返回arr中任意一个局部最小出现的位置即可。
 * 版本:
 * 运行时间:42 ms	794K
 * 备注:二分查找不用递归，尴尬！=_= ...递归的时候，return回从里到外一层层的返回，最后返回最外层return。
 */
public class Solution {
    public int getLessIndex(int[] arr) {
        if (arr.length == 0)
            return -1;
        else if (arr.length == 1)
            return 0;
        int n = arr.length - 1;
        if (arr[0] < arr[1])
            return 0;
        if (arr[n] < arr[n-1])
            return n;
        int min = binarySearch(1, n-1, arr);
        return min;
    }
    private int binarySearch(int left, int right, int[] arr){

        while(left != right){
            int mid = left + (right - left)/2;
            if (arr[mid] < arr[mid+1] && arr[mid] < arr[mid-1]){
                return mid;
            }else if (arr[mid] > arr[mid+1]){
                left= mid+1;
            }else if (arr[mid] > arr[mid-1]){
                right= mid-1;
            }
        }
        return -1;
    }
}
