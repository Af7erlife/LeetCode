package LeetCode.DP;

import LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 */
public class LeetCode139 implements LeetCode {
    @Override
    public void execute() {
        wordBreak("applepenapple", List.of(new String[]{"apple", "pen"}));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i] = false;
        }
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for(String word : wordDict) {
                if(dp[i]) break;
                if(i >= word.length() &&  i - word.length() <= len) {
                    dp[i] = (dp[i - word.length()] && s.substring(i - word.length()).startsWith(word));
                }
            }
        }
        return dp[len];
    }
}
