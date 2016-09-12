package string;

import java.util.HashMap;

/**
 * Created by zhanghe on 2016/9/12.
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。
 * 保证A中字符全部为小写英文字符，且长度小于等于500。
 * 解法：建立哈希表，代表每个字符上一次出现的位置，实时更新
 * pre：代表当前位置前一个位置的最长无重复字符的子串长度
 * 遍历字符串，若上一个相同字符与当前位置距离大于pre，pre+1，继续遍历；
 * 若小于，pre等于当前位置到上一个相同位置之间的距离
 * 记录最大的pre
 * 43 ms,772K
 */
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] str = A.toCharArray();
        int pre = 0;
        int max = 0;
        for (int i = 0; i < n; i++){
            if (!map.containsKey(str[i]) || i - map.get(str[i]) > pre){
                pre++;
                if (pre > max)
                    max = pre;
            }else {
                pre = i - map.get(str[i]);
            }
            map.put(str[i], i);
        }
        return max;
    }
}
