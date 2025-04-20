package LeetCode;

public class LeetCode53 implements LeetCode {
    public void execute(){
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;

        for (int i = 0; i < nums.length; i++) {
            curr = curr + nums[i];
            max = Math.max(max, curr);

            if (curr < 0) {
                curr = 0;
            }
        }
        return max;
    }
}