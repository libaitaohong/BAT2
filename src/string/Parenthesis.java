package string;

/**
 * Created by zhanghe on 2016/9/12.
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 27 ms,583K
 */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        char[] kuohao = A.toCharArray();
        int num = 0;
        for (int i = 0; i < n; i++){
            if (kuohao[i] == '(')
                num++;
            else if (kuohao[i] == ')')
                num--;
            else if (kuohao[i] != '(' || kuohao[i] != ')' || num < 0)
                return false;
        }
        if (num == 0)
            return true;

        return false;
    }
}
