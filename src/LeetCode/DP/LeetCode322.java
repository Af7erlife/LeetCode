package LeetCode.DP;

import LeetCode.LeetCode;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 */
public class LeetCode322 implements LeetCode {
    @Override
    public void execute() {
        coinChange(new int [] {2},3);
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //初始化dp数组
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        int length = coins.length;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
