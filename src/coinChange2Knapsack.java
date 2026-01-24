import java.util.*;

public class coinChange2Knapsack {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if(coin <= i)
                    dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
