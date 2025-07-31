package LeetCode.Backtracking;

import LeetCode.LeetCode;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * 中等
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。
 * 如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 */
public class LeetCode2044 implements LeetCode {

    @Override
    public void execute() {
        countMaxOrSubsets(new int[]{3,2,1,5});
    }
    private int count;
    private int max;

    public int countMaxOrSubsets(int[] nums) {
        count = 0;
        max = 0;
        for(int num : nums){//得到数组最大或值
            max |= num;
        }
        dfs(0,0,nums);
        return count;
    }

    /**
     * @param res 当前或值
     * @param end 当前位置
     * @param nums
     */
    public void dfs(int res,int end,int[] nums){
        if(res == max){//找到最大值，后续的数与该子串都满足题意,后续n个数选或不选构成2^n个答案
            count += 1 << (nums.length - end);
            return;
        }
        if(end < nums.length){
            dfs(res | nums[end],end + 1,nums);
            dfs(res,end + 1,nums);
        }
    }
}
