package LeetCode.Stack;

import LeetCode.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号
 */
public class LeetCode20 implements LeetCode {
    @Override
    public void execute() {
        isValid("([)]");
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
        map.put('}',' ');
        map.put(')',' ');
        map.put(']',' ');
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(map.get(stack.peek()) == s.charAt(i)){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
