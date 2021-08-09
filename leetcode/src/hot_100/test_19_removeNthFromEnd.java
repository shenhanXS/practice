package hot_100;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @author Shenhan
 * @create 2021-05-24-10:09
 */
public class test_19_removeNthFromEnd {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 双指针
        ListNode dummyHead = new ListNode(0, head);
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        while (n > 0){
            q = q.next;
            n--;
        }
        while (q.next != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;

        return dummyHead.next;

        // 两次遍历
//        if (head.next == null){
//            return null;
//        }
//
//        ListNode temp = head.next;
//        int len = 1;
//        while(temp != null){
//            len++;
//            temp = temp.next;
//        }
//
//        if (len == n){
//            return head.next;
//        }
//
//        temp = head;
//        for (int i = 1; i < len - n; i++) {
//            temp = temp.next;
//        }
//        temp.next = temp.next.next;
//
//        return head;
    }
}

