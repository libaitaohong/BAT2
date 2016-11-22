package bitOperate;

/**
 * 工程: BAT2 包名: bitOperate 类名: Swap
 * 作者: zhanghe
 * 时间: 2016/11/22 16:17
 * 题目:交换练习题
 * 内容:请编写一个算法，不用任何额外变量交换两个整数的值。
 * 给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
 * 测试样例：[1,2] 返回：[2,1]
 * 版本:
 * 运行时间:40 ms	583K
 * 备注:
 */
public class Swap {
    public int[] getSwap(int[] num) {
       num[0] = num[0]^num[1];
       num[1] = num[0]^num[1];
       num[0] = num[0]^num[1];
        return num;
    }
}
