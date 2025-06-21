package LeetCode.Halfsearch;

import LeetCode.LeetCode;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeetCode34 implements LeetCode {

    @Override
    public void execute() {
        searchRange(new int[]{6},6);
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int left = 0, right = nums.length - 1;
        int  mid = (left + right)/2;
        while(left <= right) {
            if(nums[left] == nums[right] && nums[left] == target) {
                return new int[]{left,right};
            }
            if(nums[mid] < target) {
                left = mid + 1;
                mid = (left + right)/2;
            }else if(nums[mid] > target) {
                right = mid - 1;
                mid = (left + right)/2;
            }else if(nums[mid] == target) {
                if(nums[left] == target) {//如果左边覆盖了target，则mid右移
                    mid ++;
                }else {//否则作移
                    mid --;
                }
            }
        }
        return new int[]{-1,-1};
    }
}

