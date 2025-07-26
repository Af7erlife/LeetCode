package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1957. 删除字符使字符串变好
 * 简单
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 *
 * 示例 1：
 * 输入：s = "leeetcode"
 * 输出："leetcode"
 * 解释：
 * 从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
 * 没有连续三个相同字符，所以返回 "leetcode" 。
 */
public class LeetCode1957 implements LeetCode {
    @Override
    public void execute() {
        makeFancyString("lllleeeeettttcodeeee");
    }

    public String makeFancyString(String s) {
        int count = 1;
        char last = s.charAt(0);
        StringBuffer result = new StringBuffer();
        result.append(s.charAt(0));
        for (int i = 1; i < s.length();) {
            if(count != 2){
                if(last == s.charAt(i)){
                    count++;
                }else {
                    last = s.charAt(i);
                    count = 1;
                }
                result.append(s.charAt(i++));
            }else {
                while(i < s.length() && last == s.charAt(i)) i++;
                count = 1;
            }
        }
        return result.toString();
    }
}
