package string;

/**
 * Created by zhanghe on 2016/9/8.
 * 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 * 1. 将两部分分别逆序
 * 2. 将整个字符串逆序
 * 34 ms,583K
 */
public class Translation {
    public String stringTranslation(String A, int n, int len) {
        if (n <= 1 || len == 0 || len == n)
            return A;
        char[] trans = A.toCharArray();
        getInvertString(trans, 0, len-1);
        getInvertString(trans, len, n-1);
        getInvertString(trans, 0, n-1);
        String B = String.valueOf(trans);
        return B;
    }

    private void getInvertString(char[] string, int a, int b){
        for (int i = a, j = b; i < j; i++, j--){
            swap(string, i, j);
        }
    }
    private void swap(char[] swap,int a, int b){
        char temp = swap[a];
        swap[a] = swap[b];
        swap[b] = temp;
    }
}
