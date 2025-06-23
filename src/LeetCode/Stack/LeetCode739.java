package LeetCode.Stack;

import LeetCode.LeetCode;

import java.util.*;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class LeetCode739 implements LeetCode {
    @Override
    public void execute() {

        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.add(i);

        }
        return result;
    }
}
