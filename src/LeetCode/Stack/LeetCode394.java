package LeetCode.Stack;

import LeetCode.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class LeetCode394 implements LeetCode {
    @Override
    public void execute() {
        decodeString("2[2[b]]");

    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '['){//push
                numStack.push(multi);
                stringStack.push(res.toString());
                multi = 0;
               res.delete(0, res.length());
            }else if(c>='0' && c<='9'){
                multi = multi * 10 + Integer.parseInt(String.valueOf(c));//解决多位数字
            }else if(c == ']'){
                int num = numStack.pop();
                String temp = stringStack.pop();
                String str =  temp+ res.toString().repeat(Math.max(0, num));
                res.delete(0, res.length());
                res.append(str);
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
