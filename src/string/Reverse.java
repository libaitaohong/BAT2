package string;

/**
 * Created by zhanghe on 2016/9/8.
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，
 * 也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 * 1. 实现函数将字符串所有字符逆序
 * 2. 将所有字符逆序
 * 3. 将每个单词逆序
 * 50ms,788k
 */
public class Reverse {
    public String reverseSentence(String A, int n) {
        if (n <= 1)
            return A;
        char[] a = A.toCharArray();
        getInvertString(a, 0, n-1);
        for (int i = 0, j = 0; j < n; j++){
            if (a[j] == ' ') {
                getInvertString(a, i, j - 1);
                i = j+1;
            }else if (j == n-1)
                getInvertString(a, i, j);
        }
        String B = String.valueOf(a);
        return B;
    }
    // a和b是下标
    private void getInvertString(char[] str, int a, int b){
        for (int i = a, j = b;i < j; i++,j--){
            swap(str, i, j);
        }
    }
    private void swap(char[] c, int a,int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
