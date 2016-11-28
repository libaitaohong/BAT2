package dynamicProgramming;

/**
 * 工程: BAT2 包名: dynamicProgramming 类名: GoUpstairs
 * 作者: zhanghe
 * 时间: 2016/11/28 16:32
 * 题目: 台阶问题
 * 内容:有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果
 * Mod 1000000007给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 测试样例：1  返回：1
 * 版本:
 * 运行时间:41 ms	731K
 * 备注:
 */
public class GoUpstairs {
    public int countWays(int n) {
        if(n <= 0) return 0;
        int count = 0;
        if (n == 1 || n == 2)
            count =  n;
        int s1 = 1;
        int s2 = 2;
        for (int i = 3; i <= n; i++){
            count = (s1 + s2)%1000000007;
            s1 = s2;
            s2 = count;
        }
        return count;
    }
}
