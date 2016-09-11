package string;

/**
 * Created by zhanghe on 2016/9/11.
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。
 * 假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 * 39 ms,794K
 */
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        char[] percent = new char[3000];
        char[] str = iniString.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length; i++){
            if (str[i] == ' ')
                count++;
        }
        int pos = str.length + count*2 - 1;
        for (int i = pos,j = str.length-1; i >= 0&&j>=0; i--,j--){
            if (str[j] != ' ')
                percent[i] = str[j];
            else{
                percent[i] = '0';
                percent[i-1] = '2';
                percent[i-2] = '%';
                i -= 2;
            }
        }
        String str1 = String.valueOf(percent);
        str1 = str1.substring(0,pos+1);
        return str1;
    }
}
