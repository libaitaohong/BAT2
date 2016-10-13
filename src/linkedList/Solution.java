package linkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: Solution
 * 作者: zhanghe
 * 时间: 2016/10/12 21:37
 * 题目: 复杂链表的复制
 * 内容:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * 版本:1
 * 运行时间:37 ms	566K
 * 备注:要注意临界值，注意不要出现null.next，这时会报空指针异常
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)
            return null;
        RandomListNode p = pHead;
        RandomListNode now;
        //复制节点
        while(p != null){
            now = new RandomListNode(p.label);
            now.next = p.next;
            p.next = now;
            p = now.next;
        }
        //设置rand
        p = pHead;
        RandomListNode next;
        while(p != null){
            next = p.next;
            if (p.random != null){
                next.random = p.random.next;
            }
            p = next.next;
        }
        //分离
        p = pHead;
        RandomListNode newhead = p.next;
        while(p.next != null){
            now = p.next;
            next = now.next;
            p.next = next;
            p = now;
        }
        return newhead;
    }
}
