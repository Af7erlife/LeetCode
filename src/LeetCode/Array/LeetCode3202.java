package LeetCode.Array;

import LeetCode.LeetCode;

/**
 * 3202. 找出有效子序列的最大长度 II
 * 中等
 * 给你一个整数数组 nums 和一个 正 整数 k 。
 * nums 的一个 子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ：
 * (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k
 * 返回 nums 的 最长有效子序列 的长度。
 * 输入：nums = [1,4,2,3,1,4], k = 3
 * 输出：4
 * 最长有效子序列是 [1, 4, 1, 4] 。
 */
public class LeetCode3202 implements LeetCode {
    @Override
    public void execute() {
        maximumLength(new int[]{1, 5, 9, 4, 2},2);
    }

    /**
     * 解题关键：对每个数模k,
     * (a+b) mod k=(b+c) mod k
     * 可以移项，得
     * (a+b−(b+c)) mod k=0
     * 化简得
     * (a−c) mod k=0
     * 对于 x=nums[i] mod k，我们可以在「最后两项模 k 分别为 x 和 y 的子序列」的末尾添加 nums[i]，
     * 那么「最后两项模 k 分别为 y 和 x 的子序列」的长度会增加 1，即f[y][x]=f[x][y]+1
     * 例子 f[0][1] = f[1][0] + 1 即 连续的三个数模2为  1 0 1，除开最后一项的长度是f[1][0]
     * 去数组中的最大值则是最长
     * @param nums
     * @param k
     * @return
     */
    public int maximumLength(int[] nums,int k) {
        int ans = 0;
        int[][] f = new int[k][k];
        for (int x : nums) {
            x %= k;
            for (int y = 0; y < k; y++) {
                f[y][x] = f[x][y] + 1;
                ans = Math.max(ans, f[y][x]);
            }
        }
        return ans;
    }
}
