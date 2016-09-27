package linkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: Divide
 * 作者: zhanghe
 * 时间: 2016/9/26 21:07
 * 题目: 链表的分化
 * 内容:对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，
 * 大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，
 * 大于等于它的在后，保证结点值不重复。
 * 测试样例：{1,4,2,5},3  {1,2,4,5}
 * 版本:
 * 运行时间:282 ms	4114K
 * 备注:
 */
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        if (head == null || head.next == null)
            return head;
        ListNode smallhead = null ;
        ListNode smalltail = null ;
        ListNode bighead = null;
        ListNode bigtail = null ;
        ListNode temp = null;
        ListNode p = head;
        while(p!= null){
            temp = p;
            p = p.next;
            temp.next = null;
            if (temp.val <=  val){
                if (smallhead == null){
                    smallhead = temp;
                }else{
                    smalltail.next = temp;
                }
                smalltail = temp;
            }else {
                if (bighead == null)
                    bighead = temp;
                else
                    bigtail.next = temp;
                bigtail = temp;
            }
        }
       if (smalltail == null)
           return bighead;
       else if (bigtail == null)
           return smallhead;
        smalltail.next = bighead;
        return smallhead;
    }
}
