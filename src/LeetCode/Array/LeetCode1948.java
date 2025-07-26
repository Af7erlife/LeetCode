package LeetCode.Array;

import LeetCode.LeetCode;
import java.util.List;

/**
 * 1948. 删除系统中的重复文件夹
 * 由于一个漏洞，文件系统中存在许多重复文件夹。给你一个二维数组 paths，其中 paths[i] 是一个表示文件系统中第 i 个文件夹的绝对路径的数组。
 * 例如，["one", "two", "three"] 表示路径 "/one/two/three" 。
 * 如果两个文件夹（不需要在同一层级）包含 非空且相同的 子文件夹 集合 并具有相同的子文件夹结构，则认为这两个文件夹是相同文件夹。
 * 相同文件夹的根层级 不 需要相同。如果存在两个（或两个以上）相同 文件夹，则需要将这些文件夹和所有它们的子文件夹 标记 为待删除。
 */
public class LeetCode1948 implements LeetCode {
    @Override
    public void execute() {
        deleteDuplicateFolder(List.of(
                List.of("a"),
                List.of("a", "x"),
                List.of("a", "x", "y"),
                List.of("a", "z"),
                List.of("b"),
                List.of("b", "x"),
                List.of("b", "x", "y"),
                List.of("b", "z"),
                List.of("b", "w")
        ));
    }

    /**
     * TODO
     * @param paths
     * @return
     */
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        return null;
    }
}
