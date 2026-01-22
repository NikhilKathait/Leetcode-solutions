import java.util.*;

public class houseRobber2TopDownDP {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Case 1: exclude last house
        int case1 = maxSum(nums, dp1, 0, n - 2);

        // Case 2: exclude first house
        int case2 = maxSum(nums, dp2, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int maxSum(int[] nums, int[] dp, int start, int idx) {
        if (idx < start) return 0;
        if (idx == start) return dp[idx] = nums[start];
        if (idx == start + 1) return dp[idx] =
                Math.max(nums[start], nums[start +1]);

        if (dp[idx] != -1) return dp[idx];

        dp[idx] = Math.max(
                maxSum(nums, dp, start, idx - 1),
                nums[idx] + maxSum(nums, dp, start, idx - 2)
        );

        return dp[idx];
    }
}
