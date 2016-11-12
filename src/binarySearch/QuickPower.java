package binarySearch;

/**
 * 工程: BAT2 包名: binarySearch 类名: QuickPower
 * 作者: zhanghe
 * 时间: 2016/11/12 13:53
 * 题目:快速N次方
 * 内容:如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，
 * 得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 *测试样例：2,3 返回：8
 * 版本:
 * 运行时间:
 * 备注:没做出来
 */
import java.math.BigInteger;

public class QuickPower {
    public int getPower(int a, int n) {
        BigInteger res = BigInteger.valueOf(1);
        BigInteger tmp = BigInteger.valueOf(a);
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = res.multiply(tmp);
            }
            tmp = tmp.multiply(tmp);
            res = res.mod(BigInteger.valueOf(1000000007));
            tmp = tmp.mod(BigInteger.valueOf(1000000007));
        }
        return res.mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
