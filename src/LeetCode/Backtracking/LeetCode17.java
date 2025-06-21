package LeetCode.Backtracking;

import LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 implements LeetCode {
    @Override
    public void execute() {
        letterCombinations(new String("23"));
    }
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    List<String> res = new ArrayList<>();
    public void dfs(int cur,String digits){

    }
    public List<String> letterCombinations(String digits) {
        dfs(0,digits);
        return res;
    }
}
