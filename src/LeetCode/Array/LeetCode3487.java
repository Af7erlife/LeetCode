package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.Arrays;

/**
 * 3487. 删除后的最大子数组元素和
 * 简单
 * 给你一个整数数组 nums 。
 * 你可以从数组 nums 中删除任意数量的元素，但不能将其变为 空 数组。执行删除操作后，选出 nums 中满足下述条件的一个子数组：
 * 子数组中的所有元素 互不相同 。
 * 最大化 子数组的元素和。
 * 返回子数组的 最大元素和 。
 * 子数组 是数组的一个连续、非空 的元素序列。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：
 * 不删除任何元素，选中整个数组得到最大元素和。
 */
public class LeetCode3487 implements LeetCode {
    @Override
    public void execute() {
        maxSum(new  int[]{1,2,-1,-2,1,0,-1});
    }

    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0,last = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if(last == nums[i]) continue;
            if(nums[i]< 0 && last!=Integer.MAX_VALUE ) break;
            last = nums[i];
            sum += nums[i];
        }
        return sum;
    }
}
