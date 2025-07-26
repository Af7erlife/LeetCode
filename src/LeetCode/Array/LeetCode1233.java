package LeetCode.Array;

import LeetCode.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1233. 删除子文件夹
 * 中等
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * folder[j] 的子文件夹必须以 folder[j] 开头，后跟一个 "/"。例如，"/a/b" 是 "/a" 的一个子文件夹，
 * 但 "/b" 不是 "/a/b/c" 的一个子文件夹。
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 *
 * 示例 1：
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 */
public class LeetCode1233 implements LeetCode {
    @Override
    public void execute() {
        removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"});
    }

    /**
     * 字符串按前缀排序
     * @param folder
     * @return
     */
    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();
        //字符串数组从小到大排序
        Arrays.sort(folder);
        result.add(folder[0]);
        //遍历字符串
        for (int i = 1; i < folder.length; i++) {
            String temp = folder[i];
            String last = result.getLast();
            if(!temp.startsWith(last) || temp.charAt(last.length()) != '/'){
                result.add(temp);
            }
        }
        return result;
    }
}
