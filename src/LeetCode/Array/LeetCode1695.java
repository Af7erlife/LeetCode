package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1695. 删除子数组的最大得分
 * 中等
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * <p>
 * 示例 1：
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 */
public class LeetCode1695 implements LeetCode {
    @Override
    public void execute() {
        maximumUniqueSubarray(new int[]{4,3,2,3,4,5,6});
    }

    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0, s = 0, left = 0;
        for (int x : nums) {
            while (set.contains(x)) {
                set.remove(nums[left]);
                s -= nums[left];
                left++;
            }
            set.add(x);
            s += x;
            ans = Math.max(ans, s);
        }
        return ans;
    }

    /*public int maximumUniqueSubarray(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE,sum = 0;
        int slow = 0,fast = 0;
        while(fast < length){
            if(!map.containsKey(nums[fast])){
                sum += nums[fast];
                map.put(nums[fast],fast);
                fast++;
            }else{
                max = Math.max(max,sum);
                int end = map.get(nums[fast]);
                while(slow <= end){
                    sum -= nums[slow];
                    map.remove(nums[slow]);
                    slow++;
                }
            }
        }
        return Math.max(max,sum);
    }*/
}