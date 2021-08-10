package hot_100;

import java.util.*;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
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

/*
不使用额外空间的写法
 * stack用来存储和min的差值，min存储最小值，每次出栈的时候通过差值和当前min计算要出栈的值和之前的min
 * 如果差值diff大于等于0，说明要出栈的值大于等于当前min，那么要出栈的值在入栈的时候没有更新min，返回min+diff；
 * 如果插值diff小于0，说明当前要出栈的值就是min(因为入栈的时候我们选择的就是min和入栈元素的最小值)，同时，通过min-diff计算出之前min
 * 要注意的是diff可能会超出int范围，类似于 Integer.MAX_VALUE - 1 这种，所以diff要用Long存

class MinStack {

    Integer min = null;
    Stack<Long> data = new Stack<>();

    public MinStack1() {

    }

    public void push(int x) {
        if (data.isEmpty()) {
            data.push(0L);
            min = x;
        } else {
            //如果x是最小的数，这里可能越界，所以用Long来保存
            data.push(Long.valueOf(x) - min);
            min = Math.min(x, min);
        }
    }

    public void pop() {
        Long diff = data.pop();
        if (diff >= 0) {
            //return min + diff;
        } else {
            int res = min;
            min = (int) (min - diff);
            //return res;
        }
    }

    public int top() {
        Long diff = data.peek();
        if (diff >= 0) {
            return (int) (min + diff);
        } else {
            return min;
        }
    }

    public int getMin() {
        return min;
    }
}
 */