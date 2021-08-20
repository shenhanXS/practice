package hot_100.test_148_sortList;

import hot_100.ListNode;

import java.util.Arrays;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author Shenhan
 * @create 2021-08-02-9:42
 */
public class Solution_148 {

    // 官方解法2 自底向上的归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev, curr;
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            prev = dummyHead;
            curr = prev.next;
            while (curr != null) {
                ListNode node1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode node2 = curr.next;
                curr.next = null;
                curr = node2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                curr = next;
                ListNode mergeNode = merge(node1, node2);
                prev.next = mergeNode;
                while (prev.next != null){
                    prev = prev.next;
                }
            }
        }
        return dummyHead.next;
    }

    /*
    // 官方解法1 自顶向下的归并排序
    // 时间复杂度：O(n log n) , 空间复杂度：O(log n)
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode node1 = sortList(head, mid);
        ListNode node2 = sortList(mid, tail);
        ListNode result = merge(node1, node2);
        return result;
    }
     */

    // 合并 , 方法1、2公用
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        temp.next = node1 != null ? node1 : node2;
        return dummyHead.next;
    }

}
