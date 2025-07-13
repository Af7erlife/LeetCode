package LeetCode.DP;

import LeetCode.LeetCode;

import java.util.*;

/**
 * 368. 最大整除子集
 * 中等
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 */
public class LeetCode368 implements LeetCode {
    @Override
    public void execute() {
        largestDivisibleSubset(new int[]{2,3,4,9,8});
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);//排序
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {//dp数组
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0,maxValue = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxValue = nums[i];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = dp.length-1; i >= 0; i--) {
            if (dp[i] == max && maxValue%nums[i] == 0) {
                res.add(nums[i]);
                maxValue = nums[i];
                max--;
            }
        }
        return res;
    }
}
