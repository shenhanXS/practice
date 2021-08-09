package hot_100;

import java.util.*;

/**
 * @author Shenhan
 * @create 2021-08-06-15:56
 */
public class test_155_MinStack {
}

class MinStack {

    List<Integer> stack;
    List<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
        minStack.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.add(val);
        minStack.add(Math.min(minStack.get(minStack.size() - 1), val));
    }

    public void pop() {
        stack.remove(stack.size() - 1);
        minStack.remove(minStack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}