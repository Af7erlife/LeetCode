package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.Arrays;

/**
 * 3201. 找出有效子序列的最大长度 I
 * 中等
 * 给你一个整数数组 nums。
 * nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
 * 返回 nums 的 最长的有效子序列 的长度
 * 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。
 * 示例 1：
 * 输入： nums = [1,2,3,4]
 * 输出： 4
 * 最长的有效子序列是 [1, 2, 3, 4]。
 */
public class LeetCode3201 implements LeetCode {
    @Override
    public void execute() {
        maximumLength(new int[]{1, 5, 9, 4, 2});
    }

    public int maximumLength(int[] nums) {
        int ans = 0;
        int[][] f = new int[2][2];
        for (int x : nums) {
            x %= 2;
            for (int y = 0; y < 2; y++) {
                f[y][x] = f[x][y] + 1;
                ans = Math.max(ans, f[y][x]);
            }
        }
        return ans;
    }

    /*public int maximumLength(int[] nums) {
        int res = 0;
        int[][] patterns = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (int[] pattern : patterns) {
            int cnt = 0;
            for (int num : nums) {
                if (num % 2 == pattern[cnt % 2]) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }*/
}
