package dynamicProgramming;

/**
 * 工程: BAT2 包名: dynamicProgramming 类名: dynamicProgramming
 * 作者: zhanghe
 * 时间: 2016/11/29 20:22
 * 题目:01背包
 * 内容:一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，也都有自己的重量，
 * 记录在数组w中，每件物品只能选择要装入背包还是不装入背包，要求在不超过背包承重的前提下，
 * 选出物品的总价值最大。给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * 测试样例：[1,2,3],[1,2,3],3,6  返回：6
 * 版本:
 * 运行时间:76 ms	1107K
 * 备注:i代表第几个物品，j代表当前重量，dp代表累加到当前物品当前重量最大价值
   就是从第一个物品开始从头到尾加一遍，如果重量不超，且价值变大，就带上
   j用来控制整体重量不超过cap
   如果测试用例为[1,2,3],[1,2,3],3,5，dp值如下
 *           0 1 2 3 4 5
 * i=0时，dp{0,1,1,1,1,1}
 * i=1时，dp{0,0,2,3,3,3}
 * i=2时，dp{0,0,0,3,3,5}
 * */

public class dynamicProgramming {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[] dp = new int[cap+1];
        for (int i = 0; i < n; i++){
            for (int j = cap; j >= w[i]; j--){
                dp[j] = dp[j] >= dp[j-w[i]]+v[i] ? dp[j] : dp[j-w[i]]+v[i];
            }
        }
        return dp[cap];
    }
}
