package hot_100;

import java.util.HashSet;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。
 *
 * @author Shenhan
 * @create 2021-08-09-15:45
 */
public class test_160_getIntersectionNode {

    // 计算长度
    // 时间复杂度O(m + n) , 空间复杂度O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null && ++lengthA > 0) nodeA = nodeA.next;
        while (nodeB != null && ++lengthB > 0) nodeB = nodeB.next;
        int diff = Math.abs(lengthA - lengthB);
        nodeA = headA;
        nodeB = headB;
        while (diff-- > 0) {
            if (lengthA > lengthB)
                nodeA = nodeA.next;
            else
                nodeB = nodeB.next;
        }
        while (nodeA != null) {
            if (nodeA.equals(nodeB)) {
                return nodeA;
            }else {
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }
        return null;
    }


    /* 不容易想到
    // 官方解法二 双指针
    // 时间复杂度O(m + n) , 空间复杂度O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

     */


    /* 哈希集合 , 时间复杂度O(m + n) , 空间复杂度O(m) , m和n分别是headA和headB长度
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> setA = new HashSet<>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null) {
            setA.add(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB != null) {
            if (setA.contains(nodeB)) {
                return nodeB;
            }
            nodeB = nodeB.next;
        }
        return null;
    }

     */

}
