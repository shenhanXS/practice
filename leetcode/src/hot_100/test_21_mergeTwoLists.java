package hot_100;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author Shenhan
 * @create 2021-05-30-20:23
 */
public class test_21_mergeTwoLists {

    public static void main(String[] args) {

        ListNode dummyHead = new ListNode();
        ListNode  lastNode = new ListNode();
        ListNode l1 = new ListNode(1, null);
        dummyHead.next = lastNode;
        lastNode.next = l1;
        System.out.println(dummyHead.next.val);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //递归实现
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

        // merge
//        ListNode  lastNode = new ListNode();
//        ListNode dummyHead = lastNode;
//        while (l1 != null && l2 != null){
//            if (l1.val <= l2.val){
//                lastNode.next = l1;
//                l1 = l1.next;
//            }else {
//                lastNode.next = l2;
//                l2 = l2.next;
//            }
//            lastNode = lastNode.next;
//        }
//        if (l1 != null){
//            lastNode.next = l1;
//        }else if (l2 != null){
//            lastNode.next = l2;
//        }
//        return dummyHead.next;
    }
}
