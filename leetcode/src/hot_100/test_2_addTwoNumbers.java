package hot_100;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 * @author Shenhan
 * @create 2021-05-11-20:20
 */
public class test_2_addTwoNumbers {

    public static void main(String[] args) {

        /*
        [0,8,6,5,6,8,3,5,7]
         */
        ListNode listNode1_9 = new ListNode(7, null);
        ListNode listNode1_8 = new ListNode(5, listNode1_9);
        ListNode listNode1_7 = new ListNode(3, listNode1_8);
        ListNode listNode1_6 = new ListNode(8, listNode1_7);
        ListNode listNode1_5 = new ListNode(6, listNode1_6);
        ListNode listNode1_4 = new ListNode(5, listNode1_5);
        ListNode listNode1_3 = new ListNode(6, listNode1_4);
        ListNode listNode1_2 = new ListNode(8, listNode1_3);
        ListNode listNode1_1 = new ListNode(0, listNode1_2);

        //[6,7,8,0,8,5,8,9,7]
        ListNode listNode2_9 = new ListNode(7, null);
        ListNode listNode2_8 = new ListNode(9, listNode2_9);
        ListNode listNode2_7 = new ListNode(8, listNode2_8);
        ListNode listNode2_6 = new ListNode(5, listNode2_7);
        ListNode listNode2_5 = new ListNode(8, listNode2_6);
        ListNode listNode2_4 = new ListNode(0, listNode2_5);
        ListNode listNode2_3 = new ListNode(8, listNode2_4);
        ListNode listNode2_2 = new ListNode(7, listNode2_3);
        ListNode listNode2_1 = new ListNode(6, listNode2_2);

        test_2_addTwoNumbers numbers = new test_2_addTwoNumbers();
        ListNode listNode = numbers.addTwoNumbers(listNode1_1, listNode2_2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;
        int flag = 0;
        ListNode firstNode1 = l1;
        ListNode firstNode2 = l2;
        ListNode lastNode1 = l1;
        ListNode lastNode2 = l2;
        do {
            sum = l1.val + l2.val + flag;
            if (sum >= 10) {
                l1.val = sum - 10;
                l2.val = sum - 10;
                flag = 1;
            } else {
                l1.val = sum;
                l2.val = sum;
                flag = 0;
            }

            lastNode1 = l1;
            lastNode2 = l2;
            l1 = l1.next;
            l2 = l2.next;

        } while (l1 != null && l2 != null);

        if (l1 == null) {
            while (sum >= 10) {
                if (l2 == null) {
                    lastNode2.next = new ListNode(1, null);
                    break;
                } else {
                    sum = l2.val + flag;
                    if (sum >= 10) {
                        l2.val = sum - 10;
                        flag = 1;

                        lastNode2 = l2;
                        l2 = l2.next;
                    } else {
                        l2.val = sum;
                        flag = 0;
                    }
                }
            }
            return firstNode2;
        }
        while (sum >= 10) {
            if (l1 == null) {
                lastNode1.next = new ListNode(1, null);
                break;
            } else {
                sum = l1.val + flag;
                if (sum >= 10) {
                    l1.val = sum - 10;
                    flag = 1;

                    lastNode1 = l1;
                    l1 = l1.next;
                } else {
                    l1.val = sum;
                    flag = 0;
                }
            }
        }
        return firstNode1;
    }

}
