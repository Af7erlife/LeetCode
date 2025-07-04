package LeetCode.Halfsearch;

import LeetCode.LeetCode;

/**
 * 74.搜索二维矩阵（两次二分查找或者将二维数组映射为一维并二分查找）
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class LeetCode74 implements LeetCode {

    @Override
    public void execute() {
        searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
