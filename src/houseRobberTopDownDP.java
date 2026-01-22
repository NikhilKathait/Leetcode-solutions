import java.util.*;

public class houseRobberTopDownDP {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return maxSum(nums, dp, n-1);
    }

    private int maxSum(int[] nums, int[] dp, int idx) {
        if (idx < 0) return 0;
        if (idx == 0) return dp[idx] = nums[0];
        if (idx == 1) return dp[idx] = Math.max(nums[0], nums[1]);

        if (dp[idx] != -1) return dp[idx];

        dp[idx] = Math.max(
                maxSum(nums, dp, idx - 1),
                nums[idx] + maxSum(nums, dp, idx - 2)
        );

        return dp[idx];
    }
}
