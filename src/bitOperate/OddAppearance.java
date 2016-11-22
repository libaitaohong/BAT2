package bitOperate;

/**
 * 工程: BAT2 包名: bitOperate 类名: OddAppearance
 * 作者: zhanghe
 * 时间: 2016/11/22 18:39
 * 题目: 寻找奇数出现
 * 内容:有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。
 * 要求时间复杂度为O(N)，额外空间复杂度为O(1)。给定整形数组A及它的大小n，请返回题目所求数字。
 * 测试样例：[1,2,3,2,1],5 返回：3
 * 版本:
 * 运行时间:62 ms	1423K
 * 备注:
 */
public class OddAppearance {
    public int findOdd(int[] A, int n) {
        int eo = 0;
        for(int i = 0; i < n; i++){
            eo = eo^A[i];
        }
        return eo;
    }
}
