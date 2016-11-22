package bitOperate;

/**
 * 工程: BAT2 包名: bitOperate 类名: Compare
 * 作者: zhanghe
 * 时间: 2016/11/22 17:06
 * 题目: 比较练习
 * 内容:对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。
 * 若两数相同，返回任意一个。给定两个整数a和b，请返回较大的数。
 * 测试样例：1,2 返回：2
 * 版本:
 * 运行时间:32 ms	646K
 * 备注:
 */
public class Compare {
    public int getMax(int a, int b) {
        int c = a - b;
        int as = sign(a);//a的符号，非负为1，负为0
        int bs = sign(b);//b的符号，非负为1，负为0
        int cs = sign(c);//a-b的符号，非负为1，负为0
        int difSab = as^bs; //a和b符号是否不相同，不相同为1，相同为0
        int sameSab = flip(difSab);//a和b的符号是否相同，相同为1，不同为0
        int returnA = difSab * as + sameSab * cs;
        //difSab与sameSab一个为0一个为1，当符号不同时，若a为负，则b>a，若a不负，a>b
        // 当符号相同时，cs = 0，说明a<b
        int returnB = flip(returnA);
        return a*returnA + b*returnB;

    }
    public int flip(int n){
        return n^1;
    }
    public int sign(int n){
        return flip((n >> 31) & 1);
    }
}
