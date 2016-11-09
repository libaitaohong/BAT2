package linkedList;

import java.util.List;

/**
 * 工程: BAT2 包名: linkedList 类名: ChkIntersection
 * 作者: zhanghe
 * 时间: 2016/11/9 10:50
 * 题目:有环单链表相交判断
 * 内容:如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不相交的话返回空。
 * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。给定两个链表的
 * 头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 * 版本:
 * 运行时间:71 ms	1481K
 * 备注:
 */
public class ChkIntersection {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if (head1 == null || head2 == null)
            return false;
        //1 找到两个链表进入环的第一个节点,并判断是否相等
        ListNode loopNode1 = getLoopNode(head1);
        ListNode loopNode2 = getLoopNode(head2);
        if (loopNode1 == loopNode2)
            return true;
        ListNode loop1 = loopNode1;
        while(loop1.next != loopNode1){
            loop1 = loop1.next;
            if (loop1 == loopNode2)
                return true;
        }
        return false;
    }
    private ListNode getLoopNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode next = null;
        while(fast.next != null){
            next = fast.next;
            fast = next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
