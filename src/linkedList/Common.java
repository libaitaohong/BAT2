package linkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: Common
 * 作者: zhanghe
 * 时间: 2016/9/27 19:12
 * 题目: 打印两个链表的公共值
 * 内容:现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。
 * 请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 * 测试样例：{1,2,3,4,5,6,7},{2,4,6,8,10} 返回：[2.4.6]
 * 版本:
 * 运行时间:
 * 备注:注意i是数组part的个数，不是最后一位的下标
 * 且，注意开始数组part为500位，最后需要截取有效位
 */
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return new int[] {-1};
        ListNode aa = headA;
        ListNode bb = headB;
        int[] part = new int[500];
        int i = 0;
        while(aa != null && bb != null){
            if (aa.val == bb.val){
                part[i] = aa.val;
                i++;
                aa = aa.next;
                bb = bb.next;
            }else if (aa.val > bb.val)
                bb = bb.next;
            else
                aa = aa.next;
        }
        int[] finapart = new int[i];
        for (int j = 0; j < i; j++)
            finapart[j] = part[j];
        return finapart;
    }
}
