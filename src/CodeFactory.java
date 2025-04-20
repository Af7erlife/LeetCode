import LeetCode.LeetCode;

public class CodeFactory {
    public LeetCode getLeetCodeClass(String className) throws Exception {
        Class clazz = Class.forName(className);
        return (LeetCode) clazz.newInstance();
    }
}
