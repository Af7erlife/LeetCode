package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3169. 无需开会的工作日
 * 中等
 * 给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。
 * 另给你一个二维数组 meetings，长度为 n，
 * 其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。
 * 返回员工可工作且没有安排会议的天数。
 * 注意：会议时间可能会有重叠。
 * 输入：days = 10, meetings = [[5,7],[1,3],[9,10]]
 * 输出：2
 * 解释
 * 第 4 天和第 8 天没有安排会议。
 */
public class LeetCode3169 implements LeetCode {
    @Override
    public void execute() {

        countDays(6, new int[][]{{2, 3}, {1, 5},{2,2}});
    }
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        int left = 1,right = 0;
        for(int [] meeting : meetings) {
            if(right < meeting[1]){//无法合并
                days -= (right-left + 1);
                left = meeting[0];
            }
            right = Math.max(right,meeting[1]);
        }
        days -= (right-left + 1);
        return days;
    }
    /*public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//大顶堆
                return o2 - o1;
            }
        });
        int count = 0;
        for (int i = 1, j = 0; i <= days && j<= meetings.length;) {
            while (j< meetings.length && meetings[j][0] <= i) {//将第i天开始的全都入堆
                pq.offer(meetings[j][1]);
                j++;
            }
            if (pq.isEmpty()) {//当天没有会议
                count++;
                i++;
            }
            if (!pq.isEmpty()) {//非空直接跳到最晚结束日期+1
                i = Math.max(pq.poll() + 1, i);
                pq.clear();
            }

        }
        return count;
    }*/

}
