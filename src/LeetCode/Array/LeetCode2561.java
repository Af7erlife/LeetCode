package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.*;

/**
 * 2561. 重排水果
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你有两个果篮，每个果篮中有 n 个水果。给你两个下标从 0 开始的整数数组 basket1 和 basket2 ，用以表示两个果篮中每个水果的交换成本。你想要让两个果篮相等。为此，可以根据需要多次执行下述操作：
 * 选中两个下标 i 和 j ，并交换 basket1 中的第 i 个水果和 basket2 中的第 j 个水果。
 * 交换的成本是 min(basket1i,basket2j) 。
 * 根据果篮中水果的成本进行排序，如果排序后结果完全相同，则认为两个果篮相等。
 * 返回使两个果篮相等的最小交换成本，如果无法使两个果篮相等，则返回 -1 。
 * 输入：basket1 = [4,2,2,2], basket2 = [1,4,1,2]
 * 输出：1
 * 解释：交换 basket1 中下标为 1 的水果和 basket2 中下标为 0 的水果，交换的成本为 1 。此时，basket1 = [4,1,2,2] 且 basket2 = [2,4,1,2] 。重排两个数组，发现二者相等。
 */
public class LeetCode2561 implements LeetCode {
    @Override
    public void execute() {
        minCost(new int[]{183,259,304,201,128,68,289,346,257,259,300,167,167,289,33,304,382,21,183,252},new int[]{97,128,169,21,382,169,201,68,365,183,346,97,300,257,56,183,252,365,33,56});
    }

    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < basket1.length; i++) {
            cnt.merge(basket1[i], 1, Integer::sum);  // cnt[basket1[i]]++
            cnt.merge(basket2[i], -1, Integer::sum); // cnt[basket2[i]]--
        }

        List<Integer> a = new ArrayList<>();
        int mn = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int x = e.getKey();
            int c = e.getValue();
            if (c % 2 != 0) {
                return -1;
            }
            mn = Math.min(mn, x);
            for (c = Math.abs(c) / 2; c > 0; c--) {
                a.add(x);
            }
        }

        Collections.sort(a);

        long ans = 0;
        for (int i = 0; i < a.size() / 2; i++) {
            ans += Math.min(a.get(i), mn * 2);
        }
        return ans;
    }
    
    /*public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int num : basket1){
            min = Math.min(min,num);
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        for(int num : basket2){
            min = Math.min(min,num);
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()%2 != 0){
                return -1;
            }
            for (int i = 0; i < entry.getValue()/2; i++) {
                list.add(entry.getKey());
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < basket1.length; i++) {
            if(map.containsKey(basket1[i])){
                map.put(basket1[i],map.get(basket1[i])-2);
                if(map.get(basket1[i])==0){
                    map.remove(basket1[i]);
                }
            }else {
                res.add(basket1[i]);
            }
        }
        List<Integer> res1 = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            for (int i = 0; i < entry.getValue()/2; i++) {
                res1.add(entry.getKey());
            }
        }
        Collections.sort(res1,Collections.reverseOrder());
        Collections.sort(res);
        long sum = 0;
        for (int i = 0; i < res.size(); i++) {
            long minValue = Math.min(res.get(i),res1.get(i));
            sum += Math.min(minValue,(long)min*2);
        }
        return sum;
    }*/
}
