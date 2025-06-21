package LeetCode.Backtracking;

import LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode131 implements LeetCode {
    @Override
    public void execute() {
        partition("aab");
    }

    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {//左下角以及对角线置为true
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1;i >= 0; i--) {
            for (int j = i+1 ; j < n; j++) {
                //abba为回文必须 bb为回文，即dp[0][3] = dp[1][2] && s[0] == s[3]
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        dfs(s,0);
        return res;
    }

    public void dfs(String s,int i){
        if(i == n){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j = i; j < n; j++){
            list.add(s.substring(i,j+1));
            dfs(s,j+1);
            list.remove(list.size()-1);
        }
    }

}
