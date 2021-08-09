package hot_100;

/**
 * 用来定义节点的一个公用类
 *
 * @author Shenhan
 * @create 2021-05-31-10:54
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
