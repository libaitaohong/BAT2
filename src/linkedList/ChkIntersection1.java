package linkedList;

import java.util.List;

/**
 * 工程: BAT2 包名: linkedList 类名: ChkIntersection1
 * 作者: zhanghe
 * 时间: 2016/11/9 15:26
 * 题目:单链表相交判断
 * 内容:给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？
 * 相交的话返回true，不想交的话返回false。给定两个链表的头结点head1和head2
 * (注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交
 * 版本:
 * 运行时间:79 ms	1511K
 * 备注:
 */
public class ChkIntersection1 {
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if (head1 == null || head2 == null)
            return false;
        //1 判断是否有环
        ListNode loop1 = getNode(head1);
        ListNode loop2 = getNode(head2);
        if (loop1 == null && loop2 != null)
            return false;
        else if (loop1 != null && loop2 == null)
            return false;
        else if (loop1 == null && loop2 == null){
            return noloop(head1,head2);
        }else
            return hasloop(head1,head2);
    }
    private boolean noloop(ListNode headA, ListNode headB){
        int counta = 0;
        int countb = 0;
        ListNode cura = headA;
        ListNode curb = headB;
        while (cura != null){
            counta += 1;
            cura = cura.next;
        }
        while(curb != null){
            countb += 1;
            curb = curb.next;
        }
        ListNode fir;
        ListNode sed;
        int diff = 0;
        if(counta >=countb) {
            fir = headA;
            sed = headB;
            diff = counta - countb;
        }else{
            fir = headB;
            sed = headA;
            diff = countb - counta;
        }
        while(diff > 0){
            fir = fir.next;
            diff--;
        }
        while(fir.next != null){
            if (fir.next == sed.next){
                return true;
            }
            fir = fir.next;
            sed = sed.next;
        }
        return false;
    }
    private boolean hasloop(ListNode head1, ListNode head2){
        ListNode loopNode1 = getNode(head1);
        ListNode loopNode2 = getNode(head2);
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
    private ListNode getNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode next = null;
        while (fast.next != null){
            next = fast.next;
            if (next.next != null){
                fast = next.next;
            }else{
                fast = null;
                return fast;
            }
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast.next == null){
            fast = null;
            return fast;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
