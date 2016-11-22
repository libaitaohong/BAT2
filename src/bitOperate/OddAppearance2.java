package bitOperate;

/**
 * 工程: BAT2 包名: bitOperate 类名: OddAppearance2
 * 作者: zhanghe
 * 时间: 2016/11/22 18:44
 * 题目:寻找奇数出现II
 * 内容:给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。
 * 要求时间复杂度为O(N)，额外空间复杂度为O(1)。给定一个整形数组arr及它的大小n，请返回一个数组，
 * 其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
 * 测试样例：[1,2,4,4,2,1,3,5],8 返回：[3,5]
 * 版本:
 * 运行时间:
 * 备注:
 */
public class OddAppearance2 {
    public int[] findOdds(int[] arr, int n) {
        int eo = 0, eOhasOne = 0;
        for (int cur : arr)
            eo ^= cur;
        //&运算，全1为1，其余为0，right为一位为1，其余为0的数
        int right = eo & (~eo + 1);
        for (int cur : arr){
            if ((cur & right) != 0)
                eOhasOne ^= cur;
        }
        int small = Math.min(eOhasOne,eo^eOhasOne);
        int big = Math.max(eOhasOne,eo^eOhasOne);
        return new int[]{small,big};
    }
}
