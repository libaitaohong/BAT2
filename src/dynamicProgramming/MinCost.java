package dynamicProgramming;

/**
 * 工程: BAT2 包名: dynamicProgramming 类名: MinCost
 * 作者: zhanghe
 * 时间: 2016/11/30 17:38
 * 题目:最优编辑
 * 内容:对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别
 * 为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。给定两个字符串A和B，
 * 及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，
 * 且三种代价值均小于等于100。
 * 测试样例："abc",3,"adc",3,5,3,100 返回：8
 * 版本:
 * 运行时间:50 ms	1215K
 * 备注:dp[i][j]的值应该来自三种情况：dp[i-1][j]，dp[i][j-1]和dp[i-1][j-1]
 * dp[i][j]: str1[0..i-1]->str2[0..j-1]
 * 1 来自dp[i-1][j]：str1[0..i-2]->str2[0..j-1]
 *      str1[0..i-1]->(删除str1[i-1])->str1[0..i-2],再经过dp[i-1][j]过程变成str2[0..j-1]
 *      所以dp[i][j] = c1 + dp[i-1][j]
 * 2 来自dp[i][j-1]：str1[0..i-1]->str2[0..j-2]
 *      dp[i][j-1]过程->(插入str2[j-1])->str2[0..j-1]
 *      所以dp[i][j] = dp[i][j-1] + c0
 * 3 来自dp[i-1][j-1]:str1[0..i-2]->str2[0..j-2]
 *  （1）当str1[i-2]!=str2[j-2]时
 *         先将str1[0..i-2]->str2[0..j-2]，再将str1[i-1]->(更新str1[i-1])->str2[j-1]
 *         dp[i][j] = dp[i-1][j-1] + c2
 *  （2）当str1[i-2]==str2[j-2]时
 *         将str1[0..i-2]->str2[0..j-2]，后面相同
 *         dp[i][j] = dp[i-1][j-1]
 * 选取这3中情况中最小的值作为dp[i][j]的值
 * c0:插入 c1:删除 c2:修改
 */
public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        //第一行为a为空串,a变b(插入)的代价，第一列为b为空串，a变b(删除)的代价
        int[][] dp = new int[n+1][m+1];
        int ie = 0;
        for (int i = 0; i <= n; i++){ //第一列赋值
            dp[i][0] = i*c1;
        }
        for (int j = 0; j <= m; j++){ //第一行赋值
            dp[0][j] = j*c0;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                /*if (a[i-1] == b[j-1])
                   ie = dp[i-1][j-1];
                else
                    ie = dp[i-1][j-1] + c2;*/
                ie = a[i-1] == b[j-1] ? dp[i-1][j-1] : dp[i-1][j-1] + c2;
                dp[i][j] = Math.min(ie,Math.min(dp[i-1][j]+c1,dp[i][j-1]+c0));
            }
        }
        return dp[n][m];
    }
}
