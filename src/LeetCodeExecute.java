import LeetCode.LeetCode;

public class LeetCodeExecute {
    public static void main(String[] args) {
        CodeFactory codeFactory = new CodeFactory();
        try {
            LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.Stack.LeetCode394");
            leetcode.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
