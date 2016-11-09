package linkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: CheckIntersect
 * 作者: zhanghe
 * 时间: 2016/10/16 19:21
 * 题目:无环单链表判相交
 * 内容:现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，
 * 额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
 * 版本:1
 * 运行时间:76 ms	1763K
 * 备注:
 */
public class CheckIntersect {
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return false;
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
}
