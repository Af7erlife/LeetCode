package LeetCode.Array;

import LeetCode.LeetCode;

/**
 * 2210. 统计数组中峰和谷的数量
 * 简单
 * 给你一个下标从 0 开始的整数数组 nums 。如果两侧距 i 最近的不相等邻居的值均小于 nums[i] ，则下标 i 是 nums 中，某个峰的一部分。
 * 类似地，如果两侧距 i 最近的不相等邻居的值均大于 nums[i] ，则下标 i 是 nums 中某个谷的一部分。
 * 对于相邻下标 i 和 j ，如果 nums[i] == nums[j] ， 则认为这两下标属于 同一个 峰或谷。
 * 注意，要使某个下标所做峰或谷的一部分，那么它左右两侧必须 都 存在不相等邻居。
 * 返回 nums 中峰和谷的数量。
 */
public class LeetCode2210 implements LeetCode {
    @Override
    public void execute() {
        countHillValley(new int[]{6,6,5,5,4,1});
        //countHillValley(new int[]{8,2,5,7,7,2,10,3,6,2});
    }

    public int countHillValley(int[] nums) {
        int result = 0;
        int slow = 1,fast = 2;
        while(fast < nums.length){
            while (fast<nums.length-1 && nums[slow] == nums[fast]) fast++;//如果相等直接找到下一个不相等的数
            if(nums[slow-1] < nums[slow] && nums[fast] < nums[slow]){
                result++;
            }
            if(nums[slow-1]>nums[slow] && nums[fast] > nums[slow]){
                result++;
            }
            slow = fast;
            fast++;
        }
        return result;
    }
}
