package hot_100;

import java.util.HashSet;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * @author Shenhan
 * @create 2021-07-29-9:26
 */
public class test_142_detectCycle {

    public static void main(String[] args) {
        ListNode node3 = new ListNode(-4);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node0 = new ListNode(3, node1);
        node3.next = node1;
        test_142_detectCycle detectCycle = new test_142_detectCycle();
        ListNode listNode = detectCycle.detectCycle(node0);
        System.out.println(listNode.val);

    }

    // 双指针，空间复杂度o(1)，与官方解答思想一样
    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode == null){
                return null;
            }else {
                fastNode = fastNode.next;
            }
            if (slowNode == fastNode) {
                ListNode flag = head;
                while (flag != slowNode){
                    flag = flag.next;
                    slowNode = slowNode.next;
                }
                return flag;
            }
        }
        return null;
    }

    /*
    // 基础解法，哈希表存储节点，空间复杂度o(n)
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tag = head;
        while (tag != null){
            if (set.contains(tag)){
                return tag;
            }else {
                set.add(tag);
                tag = tag.next;
            }
        }
        return null;
    }

     */
}
