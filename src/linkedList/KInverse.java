package linkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: KInverse
 * 作者: zhanghe
 * 时间: 2016/9/28 15:11
 * 题目:
 * 内容:有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 * 版本:
 * 运行时间:416 ms	4888K
 * 备注:
 */
public class KInverse {
    public ListNode inverse(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null; //记录上一组排序后的最后一个
        ListNode start = null; //记录排序后本组最后一个
        int count = 1;
        while(cur != null){
            next = cur.next;
            if (count == k){
                start = pre == null ? head : pre.next; //记录本组排序前第一个
                head = pre == null ? cur : head;
                reverse(pre, start, cur, next);
                pre = start; //逆序后，将pre设置为本组的逆序后最后位置
                count =0;
            }
            count++;
            cur = next;
        }
        return head;
    }
    //共需要四个变量：排序后上一组最后一个，未排序本组第一个，未排序本组最后一个，以及未排序下一组第一个
    private void reverse(ListNode prelast, ListNode start, ListNode end, ListNode nextfirst){
        //进行逆序
        ListNode pre = start; //首先记录第一个，也就是排序后最后一个
        ListNode cur = start.next;
        ListNode next = null;
        while(cur != nextfirst){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (prelast != null)
            prelast.next = end; //如果上一组有最后一个，则与本组排序后第一个相连
        start.next = nextfirst;//排序后本组最后一个与下一组未排序第一个相连
    }

}
