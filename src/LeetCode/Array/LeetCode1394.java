package LeetCode.Array;

import LeetCode.LeetCode;

/**
 * 1394. 找出数组中的幸运数
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 * 示例 1：
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 */
public class LeetCode1394 implements LeetCode {
    @Override
    public void execute() {
        findLucky(new int []{1,2,2,3,3,3});
    }

    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int x : arr) {
            if (x <= n) {
                cnt[x]++;
            }
        }

        for (int i = n; i > 0; i--) {
            if (cnt[i] == i) {
                return i;
            }
        }
        return -1;
    }

/*    public int findLucky(int[] arr) {
        int a = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num : arr){
            map.putIfAbsent(num,0);
            map.merge(num,1,Integer::sum);
        }
        int max = -1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(Objects.equals(entry.getKey(), entry.getValue())){
                max = Math.max(max,entry.getKey());
            }
        }
        return max;
    }*/
}
