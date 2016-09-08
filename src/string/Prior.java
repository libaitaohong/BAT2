package string;

/**
 * Created by zhanghe on 2016/9/8.
 * 对于一个给定的字符串数组，请找到一种拼接顺序，
 * 使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 * 使用归并排序，str1+str2与str2+str1比较，较小的放在前面
 * 92 ms，1635K
 */
public class Prior {
    public String findSmallest(String[] strs, int n) {
        for (int gap = 1; gap < n; gap = gap * 2){
            for (int s = 0; s < n - gap; s = s + gap*2){
                int e = s + gap*2 - 1;
                int mid = s + gap -1;
                if (e < n-1)
                    merge(strs, s, e, mid);
                else
                    merge(strs, s, n-1, mid);
            }
        }
        String strs1 = "";
        for (int i = 0; i < n; i++){
            strs1 += strs[i];
        }
        return strs1;
    }

    private void merge(String[] str, int s, int e, int mid){
        String[] merge = new String[str.length];
        for (int i = 0; i <= e; i++)
            merge[i] = str[i];
        int i = s;
        int j = mid + 1;
        for (int k = s; k <= e; k++){
            if (i > mid)
                str[k] = merge[j++];
            else if (j > e)
                str[k] = merge[i++];
            else if (compare(merge, i, j) > 0)
                str[k] = merge[j++];
            else
                str[k] = merge[i++];
        }
    }
    private int compare(String[] com, int i,int j){
        StringBuilder str1 = new StringBuilder();
        str1.append(com[i]);
        str1.append(com[j]);
        StringBuilder str2 = new StringBuilder();
        str2.append(com[j]);
        str2.append(com[i]);

        String str11 = str1.toString();
        String str22 = str2.toString();

        return str11.compareTo(str22);
    }
}
