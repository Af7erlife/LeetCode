package LeetCode.Heap;

import LeetCode.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2163. 删除元素后和的最小差值（大小堆）
 * 困难
 * 给你一个下标从 0 开始的整数数组 nums ，它包含 3 * n 个元素。
 * 你可以从 nums 中删除 恰好 n 个元素，剩下的 2 * n 个元素将会被分成两个 相同大小 的部分。
 * 前面 n 个元素属于第一部分，它们的和记为 sumfirst 。
 * 后面 n 个元素属于第二部分，它们的和记为 sumsecond 。
 * 两部分和的 差值 记为 sumfirst - sumsecond 。
 * 比方说，sumfirst = 3 且 sumsecond = 2 ，它们的差值为 1 。
 * 再比方，sumfirst = 2 且 sumsecond = 3 ，它们的差值为 -1 。
 * 请你返回删除 n 个元素之后，剩下两部分和的 差值的最小值 是多少。
 * 输入：nums = [3,1,2]
 * 输出：-1
 * 解释：nums 有 3 个元素，所以 n = 1 。
 * 所以我们需要从 nums 中删除 1 个元素，并将剩下的元素分成两部分。
 * - 如果我们删除 nums[0] = 3 ，数组变为 [1,2] 。两部分和的差值为 1 - 2 = -1 。
 * - 如果我们删除 nums[1] = 1 ，数组变为 [3,2] 。两部分和的差值为 3 - 2 = 1 。
 * - 如果我们删除 nums[2] = 2 ，数组变为 [3,1] 。两部分和的差值为 3 - 1 = 2 。
 * 两部分和的最小差值为 min(-1,1,2) = -1 。
 */
public class LeetCode2163 implements LeetCode {
    @Override
    public void execute() {
        //minimumDifference(new int[]{7,9,5,8,1,3});
        minimumDifference(new int[]{3,1,2});

    }

    /**枚举分割位置，保证两部分都至少有 n 个数。对于每个分割位置，计算最小 s1和最大s2,求最小的s1-s2
     的最小值就是答案。
     * @param nums
     * @return
     */
    public long minimumDifference(int[] nums) {
        int length = nums.length;
        int n = length/3;
        //小顶堆
        Queue<Integer> s2PriortyQueue = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        //初始化
        long sum = 0;
        for (int i = length - 1; i >length - n -1 ; i--) {
            s2PriortyQueue.offer(nums[i]);
            sum += nums[i];
        }
        //初始化中间n隔数的前缀和
        long []maxPrefix = new long[n+1];
        maxPrefix[n] = sum;
        for (int i = length - n - 1; i >=n ; i--) {
            int temp = nums[i];
            if(temp>s2PriortyQueue.peek()){//该值比堆中的最小值大
                sum -= s2PriortyQueue.poll();
                sum += temp;
                s2PriortyQueue.offer(temp);
            }
            maxPrefix[i - n] = sum;

        }

        //大顶堆
        Queue<Integer> s1ProiortyQueue = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //初始化
        long minSum = 0;
        for (int i = 0; i < n; i++) {
            s1ProiortyQueue.offer(nums[i]);
            minSum += nums[i];
        }
        long result = minSum - maxPrefix[0];
        for (int i = n; i <= length - n - 1; i++) {
            int temp = nums[i];
            if(temp < s1ProiortyQueue.peek()){//比是s1的最大值还小，替换
                minSum -= s1ProiortyQueue.poll();
                minSum += temp;
                s1ProiortyQueue.offer(temp);
            }
            result = Math.min(result,minSum - maxPrefix[i - n + 1]);
        }
        return result;
    }
}
