package LeetCode.Heap;

import LeetCode.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1353. 最多可以参加的会议数目
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。在任意一天 d 中只能参加一场会议。
 * 请你返回你可以参加的 最大 会议数目。
 */
public class LeetCode1353 implements LeetCode {
    @Override
    public void execute() {
        maxEvents(new int[][]{{1, 5}, {1, 5} ,{1, 5}, {2, 3}, {2, 3}});
    }

    public int maxEvents(int[][] events) {
        int max = 0;
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int maxValue = 0;
        for(int [] each : events){
            maxValue = Math.max(maxValue,each[1]);
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0, j = 1; j <= maxValue + 1; j++) {//遍历天数
            while (i < events.length && events[i][0] <= j) {//如果开始日期小于等于当天,则加入结束日期至最小堆
                queue.offer(events[i][1]);
                i++;
            }
            while (!queue.isEmpty() && queue.peek() < j) {//非空且结束小于当天则移除
                queue.poll();
            }
            if (!queue.isEmpty()) {//参加会议
                queue.poll();
                max++;
            }
        }
            return max;
    }
}
