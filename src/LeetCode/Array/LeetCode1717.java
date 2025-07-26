package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.*;

/**
 * 1717. 删除子字符串的最大得分（Array,Stack）
 * 中等
 * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 * 删除子字符串 "ab" 并得到 x 分。
 * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 * 删除子字符串"ba" 并得到 y 分。
 * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
 *
 * 示例 1：
 * 输入：s = "cdbcbbaaabab", x = 4, y = 5
 * 输出：19
 * 解释：
 * - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
 * - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
 * - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
 * - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
 * 总得分为 5 + 4 + 5 + 5 = 19 。
 */
public class LeetCode1717 implements LeetCode {
    @Override
    public void execute() {
        maximumGain("aabbaaxybbaabb",5,4);
    }

    public int maximumGain(String s, int x, int y) {
        char[] large = new char[]{'b','a'};
        if( x > y ){
            large = new char[]{'a','b'};
        }else {
            int temp = x;
            x = y;
            y = temp;
        }

        int length = s.length();
        int sum = 0;
        int countA = 0,countB = 0;
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'b'){//正向查询值大的键值对
                if(s.charAt(i) == large[0] ){
                    countA++;
                }else{
                    if(countA>0){//当前字符串为大值的第二位，只要第一位数量>0，则加上大值
                        countA--;
                        sum += x;
                    }else {
                        countB++;
                    }
                }
            }else if(countA !=0 || countB != 0){//遇到非a,b，值为小值*min(a,b)
                sum += y * Math.min(countA,countB);
                countA = 0;
                countB = 0;
            }
        }

        return  sum + y * Math.min(countA,countB);
    }
}