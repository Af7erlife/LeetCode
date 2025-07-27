import LeetCode.LeetCode;

public class LeetCodeExecute {
    public static void main(String[] args) {
        CodeFactory codeFactory = new CodeFactory();
        try {
            //LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.Heap.LeetCode2163");
            //LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.DP.LeetCode5");
            LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.Array.LeetCode3480");
            //LeetCode leetcode = codeFactory.getLeetCodeClass("LeetCode.HashMap.LeetCode1394");
            leetcode.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
