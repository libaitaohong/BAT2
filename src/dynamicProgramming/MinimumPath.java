package dynamicProgramming;

/**
 * 工程: BAT2 包名: dynamicProgramming 类名: MinimumPath
 * 作者: zhanghe
 * 时间: 2016/11/28 17:16
 * 题目:矩阵最小路径和
 * 内容:有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达
 * 右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 * 测试样例：[[1,2,3],[1,1,1]],2,3  返回：4
 * 版本:
 * 运行时间:96 ms	1866K
 * 备注:step[i][j]= min(step[i-1][j],step[i][j-1])
 */
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        int[][] step = new int[n][m];
        step[0][0] = map[0][0];
        for (int j = 1; j < m; j++){
            step[0][j] = map[0][j] + step[0][j-1];
        }
        for (int i = 1; i < n; i++){
            step[i][0] = map[i][0] + step[i-1][0];
        }
        for(int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                step[i][j] = Math.min(step[i][j-1],step[i-1][j]) + map[i][j];
            }
        }
        return step[n-1][m-1];
    }
}
