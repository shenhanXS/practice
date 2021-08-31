package hot_100.test_234_isPalindrome;

import hot_100.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
 *
 * @author Shenhan
 * @create 2021-08-31-15:09
 */
public class Solution_234 {

    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null) {
            p2 = p2.next;
            if (p2 != null) {
                p1 = p1.next;
            }else {
                break;
            }
            p2 = p2.next;
        }
        ListNode reverse = reverse(p1);
        ListNode temp1 = reverse;
        ListNode temp2 = head;
        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        reverse(reverse);
        return true;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
