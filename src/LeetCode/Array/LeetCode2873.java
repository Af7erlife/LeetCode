package LeetCode.Array;

import LeetCode.LeetCode;

/**
 * 2873. 有序三元组中的最大值 I
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 * 输入：nums = [12,6,1,2,7]
 * 输出：77
 * 解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
 * 可以证明不存在值大于 77 的有序下标三元组。
 */
public class LeetCode2873 implements LeetCode {
    @Override
    public void execute() {
        maximumTripletValue(new int[]{12, 6, 1, 2, 7});
    }

    public long maximumTripletValue(int[] nums) {
        long ans = 0, maxDiff = 0, max = 0;
        for (int num : nums) {
            ans = Math.max(maxDiff * num, ans);
            maxDiff = Math.max(maxDiff, max - num);
            max = Math.max(max, num);
        }
        return ans;
    }
}
