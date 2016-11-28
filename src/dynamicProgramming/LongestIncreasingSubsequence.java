package dynamicProgramming;

/**
 * 工程: BAT2 包名: dynamicProgramming 类名: LongestIncreasingSubsequence
 * 作者: zhanghe
 * 时间: 2016/11/28 19:16
 * 题目: LIS练习题
 * 内容:这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序
 * 列的长度。给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 * 测试样例：[1,4,2,5,3],5  返回：3
 * 版本:
 * 运行时间:70 ms	1214K
 * 备注:注意，max初始为0，但是数组lp最小为1，所以不能再if里面lp[j]+1
 */
public class LongestIncreasingSubsequence {
    public int getLIS(int[] A, int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] lp = new int[n];
        lp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (A[j] < A[i]){
                    if (lp[j] >= max)
                        max = lp[j];
                }
            }
            lp[i] = max + 1;
            max = 0;
        }
        //max = 0;
        for (int k = 0; k < n; k++){
            if (lp[k] > max)
                max = lp[k];
        }
        return max;
    }
}
