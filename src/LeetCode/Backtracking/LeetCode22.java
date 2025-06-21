package LeetCode.Backtracking;

import LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeetCode22 implements LeetCode {

    @Override
    public void execute() {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int left = n;
        int right = n;
        dfs(res, left, right,"");
        return res;
    }

    void dfs(List<String> res,int left,int right,String now) {
        if(left > right) return;
        String result = now;
        if(left == 0 ) {
            for (int i = 0; i < right; i++) {
                result = result + ")";
            }
            res.add(result);
            return;
        }
        dfs(res, left-1, right, now+"(");
        dfs(res, left, right-1, now+")");
    }
}
