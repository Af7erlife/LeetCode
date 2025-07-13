package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *2410. 运动员和训练师的最大匹配数（双指针）
 * 给你一个下标从 0 开始的整数数组 players ，其中 players[i] 表示第 i 名运动员的 能力 值，同时给你一个下标从 0 开始的整数数组 trainers ，其中 trainers[j] 表示第 j 名训练师的 训练能力值 。
 * 如果第 i 名运动员的能力值 小于等于 第 j 名训练师的能力值，那么第 i 名运动员可以 匹配 第 j 名训练师。除此以外，每名运动员至多可以匹配一位训练师，每位训练师最多可以匹配一位运动员。
 * 请你返回满足上述要求 players 和 trainers 的 最大 匹配数。
 * 输入：players = [4,7,9], trainers = [8,2,5,8]
 * 输出：2
 * 解释：
 * 得到两个匹配的一种方案是：
 * - players[0] 与 trainers[0] 匹配，因为 4 <= 8 。
 * - players[1] 与 trainers[3] 匹配，因为 7 <= 8 。
 * 可以证明 2 是可以形成的最大匹配数。
 */
public class LeetCode2410 implements LeetCode {
    @Override
    public void execute() {

        matchPlayersAndTrainers(new int[]{4,7,9},new int []{8,2,5,8} );
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        for (int i = 0,j = 0; i < players.length && j< trainers.length;j++ ) {
            while(j < trainers.length-1 && players[i] > trainers[j]){//加速迭代
                j++;
            }
            if(players[i] <= trainers[j]){
                count++;
                i++;
            }
        }
        return count;
    }

}
