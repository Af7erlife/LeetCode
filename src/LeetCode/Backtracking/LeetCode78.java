package LeetCode.Backtracking;

import LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 implements LeetCode {
    @Override
    public void execute() {
        subsets(new int[]{1,2,3});
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums){
        dfs(nums,0);
        res.add(new ArrayList<>());
        return res;
    }

    public void dfs(int []nums,int cur)
    {
        if(list.size() == nums.length){
            return;
        }else if(cur>nums.length){
            return;
        }
        for(int i =cur;i<nums.length;i++){
            list.add(nums[i]);
            res.add(new ArrayList(list));
            dfs(nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
