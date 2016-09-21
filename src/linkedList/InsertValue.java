package linkedList;

import java.util.List;

/**
 * 工程: BAT2 包名: linkedList 类名: InsertValue
 * 作者: zhanghe
 * 时间: 2016/9/20 21:15
 * 题目:环形链表插值
 * 内容:有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * 测试用例：[1,3,4,5,7],[1,2,3,4,0],2   返回：{1,2,3,4,5,7}
 * 版本:
 * 运行时间:
 * 备注:牛客值有单链表提交能够通过，所以将31行注释变成单链表
 */
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        ListNode node = new ListNode(val);
        if (A == null || A.length ==0)
            return node;
        ListNode head = new ListNode(A[0]);
        ListNode p = head;
        ListNode next = null;
        //创建单向链表
        for (int i = 0; i < A.length-1; i++){
             next = new ListNode(A[nxt[i]]);
            p.next = next;
            p = next;
        }
        //p.next = head;
        //循环比较

        ListNode pp = head;
        ListNode rr = pp.next;
        while(rr != null){
            if (pp.val <= val && val < rr.val){
                break;
            }
            pp = rr;
            rr = pp.next;
        }
        pp.next = node;
        node.next = rr;
        if (rr == head && val < rr.val)
            head = node;
        return head;
    }
}
