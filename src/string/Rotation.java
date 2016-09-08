package string;

/**
 * Created by zhanghe on 2016/9/7.
 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。
 * 比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
 * 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
 * 将str1+str1并使用KMP计算是否str2是大字符串的子串
 * 33m，773k
 */
public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        if (lena != lenb)
            return false;
        char[] str1 = A.toCharArray();
        char[] str2 = B.toCharArray();
        char[] str12 = new char[lena+lenb];
        for (int i = 0; i < lena; i++){
            str12[i] = str1[i];
            str12[i+lena] = str1[i];
        }
       //next函数
        int[] next = nextArray(str2);
        //匹配,首先定义str12和str2的当前位置
        int ai = 0;
        int bi = 0;
        while(bi < str2.length && ai < str12.length){
            if (str12[ai] == str2[bi]){
                ai++;
                bi++;
            }else if (next[bi] >= 0)
                bi = next[bi]; //这里若一直匹配不上，bi会一直到0
            else
                ai++;
        }
        if (bi == str2.length){
            return true;
        }
        return false;
    }

    private int[] nextArray(char[] b){
        if (b.length == 0)
            return new int[] {-1};
        int[] next = new int[b.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0; //1.下标:代表pos-1位置的最长相同前缀的后一位.2.数字：代表代表pos-1位置的最长相同前缀的长度
        while (pos < b.length){
            if (b[pos-1] == b[cn])
                next[pos++] = ++cn;
            else if (cn > 0)
                cn = next[cn];
            else
                next[pos++] = 0;
        }

        return next;
    }
}
