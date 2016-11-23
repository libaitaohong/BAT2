package dynamicProgramming;

/**
 * 工程: BAT2 包名: dynamicProgramming 类名: Exchange
 * 作者: zhanghe
 * 时间: 2016/11/23 17:19
 * 题目:找零钱
 * 内容:有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币
 * 可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * 测试样例：[1,2,4],3,3 返回：2
 * 版本:
 * 运行时间:34 ms	835K
 * 备注:
 * 1 暴力
 public int coin1(int[] arr, int aim){
    if (arr == null || arr.length == 0 || aim < 0)
        return 0;
    return process1(arr, 0, aim);
 }
 public int process1(int[] arr, int index, int aim){
    int res = 0;
    if (index == arr.length){
        res = aim == 0 ? 1 : 0;
    }else{
        for (int i = 0; arr[index] * i <= aim; i++){
        res += process1(arr, index + 1, aim - arr[index] * i);
        }
    }
    return res;
 }
 2 记忆搜索
 准备数组map，记录每一个递归过程的结果，下次递归前，查找数组，若已经递归过，将结果直接拿来用
 map是一张二维表。map[i][j]表示递归过程p(i,j)的返回值。
 map[i][j]==0表示递归过程p(i,j)从来没有计算过，map[i][j]==-1表示计算过，但返回值是0
 map[i][j]既不等于0也不等于-1，记为a，表示递归过程的返回值为a
 public int coins2(int[] arr, int aim){
    if (arr == null || arr.length == 0 || aim < 0) return 0;
    int[][] map = new int[arr.length][aim+1];
    return process2(arr, 0, aim, map);
 }
 public int process2(int[] arr, int index, int aim, int[][] map){
    int res = 0;
    if (index == arr.length){
        res = aim == 0 ? 1 : 0;
     }else{
        int mapVlaue = 0;
        for (int i = 0; arr[index] * i <= aim; i++){
            mapVlaue = map[index+1][aim-arr[index] * i];
            if (mapVlaue != 0){
                 res += mapVlaue == -1 ? 0 : mapVlaue;
            }else{
                res += process2(arr, index + 1, aim - arr[index] * i, map);
            }
        }
    }
    map[index][aim] = res == 0 ? -1 : res;
    return res;
 }
 3 动态规划方法
 dp[N][aim+1]，dp[i][j]的含义是在使用arr[0...i]货币的情况下，组成钱数j有多少种方法。
 dp[i][j]的值求法如下
 1 对于矩阵dp第一列的值dp[..][0],表示组成钱数为0的方法数，很明显是1中，也就是不使用任何货币，dp第一
 列的值统一设置为1.
 2 对于矩阵dp第一行的值dp[0][..]，表示只能使用arr[0]这一种货币的情况下，组成钱的方法数。比如，
 arr[0]==5时，能组成钱数的只有0,5,10...。所以，令dp[0][k*arr[0]]=1(0<=k*arr[0]<=aim,k非负整数)
 3 除了第一行和第一列的其他位置，记为位置(i,j)。dp[i][j]的值是一下几个值的累加
    用0张arr[i]货币，剩下的钱使用arr[0..i-1]货币组成时，方法数为dp[i-1][j]
    用1张arr[i]货币，剩下的钱使用arr[0..i-1]货币组成时，方法数为dp[i-1][j-arr[i]]
    用2张arr[i]货币，剩下的钱使用arr[0..i-1]货币组成时，方法数为dp[i-1][j-2*arr[i]]
    ...
    用k张arr[i]货币，剩下的钱使用arr[0..i-1]货币组成时，方法数为dp[i-1][j-k*arr[i]]
    j-k*arr[i]>=0,k为非负整数
 4 最终dp[N-1][aim]的值就是最终结果
 public int coins3(int[] arr, int aim){
    if (arr == null || arr.length == 0 || aim < 0) return 0;
    int[][] dp = new int[arr.length][aim+1];
    for (int i = 0; i < arr.length; i++)
        dp[i][0] = 1;
    for (int j = 1; arr[0]*j <= aim; j++)
        dp[0][arr[0]*j] = 1;
    int num = 0;
    for (int i = 1; i < arr.length; i++){
        for (int j = 1; j <= aim; j++){
            num = 0;
            for (int k = 0; j - arr[i] * k >= 0; k++){
                num += dp[i-1][j-arr[i]*k];
            }
            dp[i][j] = num;
        }
     }
    return  dp[arr.length-1][aim];
 }
 在最差的情况下，对位置(i,j)来说，求解dp[i][j]的计算过程需要枚举dp[i-1][0..j]上的所有值，dp一共有
 N*aim个位置，所以总体的时间复杂度为O(N*aim^2)
 4 时间复杂度为O(N*aim)的动态规划
 看上一个动态规划算法步骤3：
 第一种情况的方法数为dp[i-1][j],而第2种情况一直到第k种情况的方法数累加其实就是dp[i][j-arr[i]]的值。
 所以步骤3可以简化为dp[i][j]=dp[i-1][j]+dp[i][j-arr[i]]，时间复杂度缩小为O(N*aim)
 public int coins4(int[] arr, int aim){
    if (arr == null || arr.length == 0 || aim < 0) return 0;
    int[][] dp = new int[arr.length][aim+1];
    for (int i = 0; i < arr.length; i++)
        dp[i][0] = 1;
    for (int j = 1; arr[0]*j <= aim; j++)
        dp[0][arr[0]*j] = 1;
    for (int i = 1; i < arr.length; i++){
        for (int j = 1; j <= aim; j++){
            dp[i][j] = dp[i-1][j];
            dp[i][j] += j - arr[i] >= 0 ? dp[i][j-arr[i]] : 0;
        }
    }
    return  dp[arr.length-1][aim];
 }
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        if (penny == null || penny.length == 0 || aim < 0) return 0;
        int[][] dp = new int[penny.length][aim+1];
        for (int i = 0; i < penny.length; i++)
            dp[i][0] = 1;
        for (int j = 1; penny[0]*j <= aim; j++)
            dp[0][penny[0]*j] = 1;
        for (int i = 1; i < penny.length; i++){
            for (int j = 1; j <= aim; j++){
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j - penny[i] >= 0 ? dp[i][j-penny[i]] : 0;
            }
        }
        return  dp[penny.length-1][aim];
    }
}
