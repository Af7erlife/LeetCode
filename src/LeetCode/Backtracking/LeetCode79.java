package LeetCode.Backtracking;

import LeetCode.LeetCode;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class LeetCode79 implements LeetCode {

    @Override
    public void execute() {
        exist(new char[][]{{'C','A','A'}, {'A','A','A'},{'B','C','D'}},"AAB");
    }

    private boolean result = false;

    public boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(!result){
                        String now = String.valueOf(board[i][j]);
                        result = dfs(board,word,i,j,now);
                    }
                }
            }
        }
        return result;
    }

    boolean dfs(char[][] board, String word,int m,int n,String now) {
        if(now.equals(word)) {
            result = true;
            return true;
        }
        int len = board[0].length;
        int width = board.length;
        char t = board[m][n];
        board[m][n] = ' ';
        if(m >= 0 && n >= 0 && m+1 < width && n < len && !result && word.startsWith(now+board[m+1][n])) {
            result = dfs(board,word,m+1,n,now+board[m+1][n]);
        }
        if(m >= 0 && n >= 0 && m < width && n+1 < len && !result && word.startsWith(now+board[m][n+1])) {
            result = dfs(board,word,m,n+1,now+board[m][n+1]);
        }
        if(m-1>=0 && n >= 0 && m < width && n < len && !result && word.startsWith(now+board[m-1][n])) {
            result = dfs(board,word,m-1,n,now+board[m-1][n]);
        }
        if(m>=0 && n-1 >= 0 && m < width && n < len && !result && word.startsWith(now+board[m][n-1])) {
            result = dfs(board,word,m,n-1,now+board[m][n-1]);
        }
        board[m][n] = t;
        return result;
    }
}
