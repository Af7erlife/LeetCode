package LeetCode.Stack;

import LeetCode.LeetCode;

import java.util.*;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class LeetCode155 implements LeetCode {
    @Override
    public void execute() {
        new MinStack();
    }

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            if(minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            if(Objects.equals(minStack.peek(), stack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.getLast();
        }
    }
}
