package binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 工程: BAT2 包名: binaryTree 类名: FoldPaper
 * 作者: zhanghe
 * 时间: 2016/11/16 20:50
 * 题目:折纸
 * 内容:请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，
 * 突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。
 * 如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。给定折的次数n,请返回从
 * 上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 * 测试样例：1 返回：["down"]
 * 版本:
 * 运行时间:
 * 备注:
 */
public class FoldPaper {
    public String[] foldPaper(int n) {
        LinkedList<String> list = new LinkedList<>();
        flod(1, n, true, list);
        String[] res=new String[list.size()];
        int j = list.size();
        for(int i=0; i < j; i++){
            res[i]=list.pop();
        }
        return res;
    }
    private void flod(int i, int n, boolean b, LinkedList<String> list){
        if (i > n) return;
        flod(i+1, n, true, list);
        list.add(b ? "down" : "up");
        flod(i+1, n, false, list);
    }
}
