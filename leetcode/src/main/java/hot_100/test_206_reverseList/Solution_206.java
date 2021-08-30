package hot_100.test_206_reverseList;

import hot_100.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * @author Shenhan
 * @create 2021-08-12-19:18
 */
public class Solution_206 {

    // 迭代
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextHead = head.next;
        head.next = null;
        while (nextHead != null) {
            ListNode temp = nextHead.next;
            nextHead.next = head;
            head = nextHead;
            nextHead = temp;
        }
        return head;
    }

    /*
    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
     */

}
