package LeetCode.Array;

import LeetCode.LeetCode;

/**
 * 8. 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
 * 函数 myAtoi(string s) 的算法如下：
 * 空格：读入字符串并丢弃无用的前导空格（" "）
 * 符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
 * 转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
 * 舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
 * 返回整数作为最终结果。
 */
public class LeetCode8 implements LeetCode {
    @Override
    public void execute() {
        System.out.println(myAtoi("21474836460"));
    }

    public int myAtoi(String s) {
        char[] c = s.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0;
        int boundary = Integer.MAX_VALUE / 10;
        int i = 1;
        // 默认正数
        int sign = 1;
        // 首字符判断
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }

        for (int j = i; j < c.length; j++) {
            // 非数字直接退出
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            /**
             * boundary 是 2147483647
             当 res > boundary 时，无论 res 最后一位是多少，都会溢出
             当 res == boundary 且最后一位是 8、9 时，也会溢出
             */
            if (res > boundary || res == boundary && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;

    }
}
