package linkedList;

/**
 * 工程: BAT2 包名: linkedList 类名: Remove
 * 作者: zhanghe
 * 时间: 2016/9/20 21:18
 * 题目:访问单个节点的删除
 * 内容:实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定带删除的节点，请执行删除操作，若该节点为尾节点，返回false，否则返回true
 * 版本:
 * 运行时间:36 ms	583K
 * 备注:
 */
public class Remove {
    public boolean removeNode(ListNode pNode) {
        if (pNode.next == null)
            return false;
        pNode.val = pNode.next.val;
        pNode.next = pNode.next.next;
        return true;
    }
}
