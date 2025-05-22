import LeetCode.LeetCode;

public class main {
    public static void main(String[] args) {
        CodeFactory codeFactory = new CodeFactory();
        try {
            LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.LeetCode78");
            leetcode.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
