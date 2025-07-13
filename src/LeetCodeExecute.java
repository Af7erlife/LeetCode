import LeetCode.LeetCode;

public class LeetCodeExecute {
    public static void main(String[] args) {
        CodeFactory codeFactory = new CodeFactory();
        try {
            //LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.Heap.LeetCode1353");
            //LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.DP.LeetCode368");
            LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.Array.LeetCode3169");
            leetcode.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
