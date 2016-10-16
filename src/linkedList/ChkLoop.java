package linkedList;

import java.util.LinkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: ChkLoop
 * 作者: zhanghe
 * 时间: 2016/10/13 20:24
 * 题目:链表判环
 * 内容:如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 * 版本:1
 * 运行时间:
 * 备注:忘记写next = fast.next;了，注意小细节
 */
public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
        if(head == null)
            return -1;
        ListNode fast = head;
        ListNode slow = head;
        ListNode next = fast.next;
        while(next != null){
            if (next.next !=null){
                fast = next.next;
                next = fast.next;
            }else{
                return -1;
            }
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (next == null)
            return -1;
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast.val;
    }
}
