import java.util.*;

public class perfectSquaresKnapsack {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int num = 1; num * num <= i; num++) {
                dp[i] = Math.min(dp[i], dp[i - num*num] + 1);
            }
        }

        return dp[n];
    }
}
