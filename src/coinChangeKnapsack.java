import java.util.*;

public class coinChangeKnapsack {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // Iterate over coins
        for (int coin : coins) {

            // If we pick a coin of value 'coin'
            for (int curr = coin; curr <= amount; curr++) {
                // Either keep current best, or use this coin (+1) and solve remaining amount
                dp[curr] = Math.min(dp[curr], 1 + dp[curr - coin]);
            }
        }

        return dp[amount] > amount ? -1: dp[amount];
    }
}
