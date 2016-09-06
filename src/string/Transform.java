package string;

/**
 * Created by zhanghe on 2016/9/4.
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同,则A和B互为变形词，
 * 请设计一个高效算法，检查两给定串是否互为变形词.
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * Unicode字符集有65535个字符，所以使用数组代替哈希表
 * 1 新建长度为65536的数组map
 * 2 将两个字符串转换成char数组arr1 arr2
 * 3 根据arr1中字符的Unicode码确定map数组对应位置数
 * 4 再根据srr2中字的Unicode码将map数组对应位置依次减一
 * 6 若map数组中所有数都为0，则是变形词
 * 时间39ms，2709k
 */
public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        if (lena != lenb){
            return false;
        }
        int[] map = new int[65536];
        char[] arr1 = A.toCharArray();
        char[] arr2 = B.toCharArray();
        for (int i = 0; i < lena; i++){
            map[arr1[i]] = map[arr1[i]] + 1;
        }
        for (int i = 0; i < lenb; i++){
            map[arr2[i]] = map[arr2[i]] - 1;
        }
        for (int i = 0; i < 65536; i++){
            if (map[i] != 0)
                return false;
        }

        return true;
    }
}
