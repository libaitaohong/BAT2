package linkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: Palindrome
 * 作者: zhanghe
 * 时间: 2016/10/10 16:02
 * 题目:链表的回文结构
 * 内容:请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * 测试样例：{1,2,3,2,1} 返回：true    {1,2,3,2,3}    返回：false
 * 版本:1
 * 运行时间:38 ms	869K
 * 备注:时间O(n),空间O(1)
 */
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        int odd = 1; //长度为奇数
        while(fast.next != null){
            if (fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }else {
                fast = fast.next;
                odd = 0; //长度为偶数
            }
        }
        ListNode fp = slow; //后半部分进行逆序
        ListNode fnow = fp.next;
        ListNode fnext;
        slow.next = null;
        while(fnow != null){
            fnext = fnow.next;
            fnow.next = fp;
            fp = fnow;
            fnow = fnext;
        }
        ListNode phead = pHead;
        if (odd == 1){
            while(fp != phead){
                if (fp.val != phead.val){
                    return false;
                }
                fp = fp.next;
                phead = phead.next;
            }
        }else{
            while(fp != slow){
                if (fp.val != phead.val)
                    return false;
                fp = fp.next;
                phead = phead.next;
            }
        }
        return true;
    }
}
