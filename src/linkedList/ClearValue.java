package linkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: ClearValue
 * 作者: zhanghe
 * 时间: 2016/10/10 15:30
 * 题目:链表指定值清除
 * 内容:现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。
 * 请保证其他元素的相对顺序。
 * 测试样例：{1,2,3,4,3,2,1},2   结果：{1,3,4,3,1}
 * 版本:1
 * 运行时间:227 ms	2914K
 * 备注:
 */
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
        ListNode head1 = null;
        ListNode tail = null;
        ListNode now = head;
        ListNode next;
        while (now != null){
            next = now.next;
            if (now.val != val){
                if (head1 == null){
                    head1 = now;
                    tail = now;
                }
                tail.next = now;
                tail = tail.next;
                tail.next = null;
            }
            now = next;
        }
        return head1;
    }
}
