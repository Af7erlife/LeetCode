package LeetCode.DP;

import LeetCode.LeetCode;

import java.util.Arrays;

/**
 * 5. 最长回文子串
 * 中等
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 更新dp
 * cbb的dp
 * 1 0 0
 * 1 1 0
 * 1 1 1
 */
public class LeetCode5 implements LeetCode {
    @Override
    public void execute() {
        longestPalindrome("cbab");
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[] dp = new boolean[length];
        Arrays.fill(dp, true);
        int begin = 0, maxLen = 1;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if (j - i == 1) {
                    dp[j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[j] = dp[j - 1] && (s.charAt(j) == s.charAt(i));//更新dp
                }
                if (dp[j] && (j - i + 1) > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /*public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        int begin = 0, maxLen = 1;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));//更新dp
                if (dp[i][j] && (j - i + 1) > maxLen) {//更新maxLen
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }*/
}
