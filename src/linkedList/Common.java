package linkedList;

import java.util.LinkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: Common
 * 作者: zhanghe
 * 时间: 2016/9/27 19:12
 * 题目: 打印两个链表的公共值
 * 内容:现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。
 * 请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 * 测试样例：{1,2,3,4,5,6,7},{2,4,6,8,10} 返回：[2.4.6]
 * 版本:2
 * 运行时间:94 ms	1976K
 * 备注:取消数组，使用链表。另外不用新建两个节点指向链表，直接使用链表的头结点即可
 * 在最后进行for循环时，链表的大小一直在改变，所以不能用链表大小与j比较
 * */
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return new int[] {-1};

        LinkedList<Integer> part = new LinkedList<>();
        while(headA != null && headB != null){
            if (headA.val == headB.val){
                part.add(headA.val);
                headA = headA.next;
                headB = headB.next;
            }else if (headA.val > headB.val)
                headB = headB.next;
            else
                headA = headA.next;
        }
        int[] finapart = new int[part.size()];
        int k = part.size();
        for (int j = 0; j < k; j++){
            finapart[j] = part.pollFirst();
        }
        return finapart;
    }
}
