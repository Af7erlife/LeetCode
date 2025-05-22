package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 implements LeetCode {
    List<List<Integer>> res;
    List<Integer> list;
    public void execute(){
        permute(new int[]{1,2,3});
    }

    /**
     * 交换i,j的元素位置
     * @param i
     * @param j
     */
    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * 回溯，num为当前深度，当深度为总长度时加入结果
     * @param num
     */
    public void dfs(int num){
        if(num == list.size()-1){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = num; i < list.size(); i++) {
            swap(i, num);
            dfs(num+1);
            swap(i, num);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        this.list = new ArrayList<>();
        this.res = new ArrayList<>();
        for(int num : nums){
            this.list.add(num);
        }
        dfs(0);
        return res;
    }
}
