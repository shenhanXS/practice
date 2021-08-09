package hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author Shenhan
 * @create 2021-07-30-11:31
 */
public class test_146_LRUCache {
}

class LRUCache {

    // 官方解答
    // 自定义一个双向链表
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode preNode;
        DLinkedNode nextNode;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.nextNode = tail;
        tail.preNode = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null){
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            insertToHead(node);
            size++;
            if (size > capacity){
                DLinkedNode temp = removeTail();
                cache.remove(temp.key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        insertToHead(node);
    }
    public void removeNode(DLinkedNode node){
        node.preNode.nextNode = node.nextNode;
        node.nextNode.preNode = node.preNode;
    }
    public void insertToHead(DLinkedNode node){
        node.preNode = head;
        node.nextNode = head.nextNode;
        head.nextNode.preNode = node;
        head.nextNode = node;
    }
    public DLinkedNode removeTail(){
        DLinkedNode temp = tail.preNode;
        removeNode(temp);
        return temp;
    }

    /* TLE
    int capacity;
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, Integer> sort = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    public int get(int key) {
        if (map.containsKey(key)){
            // 改变顺序
            changeSort(key);
            return map.get(key);
        }else {
            return -1;
        }
    }
    public void put(int key, int value) {
        // 改变已有的
        if (map.containsKey(key)){
            map.put(key, value);
            changeSort(key);
            return;
        }
        // 容量未满，新增
        if (map.size() < capacity){
            map.put(key, value);
            sort.put(sort.size() + 1, key);
            // 容量已满，删除后新增
        }else if (map.size() == capacity){
            map.remove(sort.get(capacity));
            map.put(key, value);
        }
        for (int i = sort.size(); i > 1; i--) {
            sort.put(i, sort.get(i - 1));
        }
        sort.put(1, key);
    }
    public void changeSort(int key){
        int flag = 0;
        for (int i = 1; i <= sort.size(); i++) {
            if (sort.get(i) == key){
                flag = i;
                break;
            }
        }
        for (int i = flag; i > 1; i--) {
            sort.put(i, sort.get(i - 1));
        }
        sort.put(1, key);
    }
     */
}
