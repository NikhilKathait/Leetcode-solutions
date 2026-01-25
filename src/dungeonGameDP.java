public class dungeonGameDP {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[] dp = new int[n];

        // Base case: princess cell (bottom-right)
        dp[n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        // Fill last row
        for (int j = n - 2; j >= 0; j--) {
            dp[j] = Math.max(1, dp[j + 1] - dungeon[m - 1][j]);
        }

        // Process remaining rows (bottom to top)
        for (int i = m - 2; i >= 0; i--) {

            // Last column
            dp[n - 1] = Math.max(1, dp[n - 1] - dungeon[i][n - 1]);

            // Other columns
            for (int j = n - 2; j >= 0; j--) {
                int need = Math.min(dp[j], dp[j + 1]);
                dp[j] = Math.max(1, need - dungeon[i][j]);
            }
        }

        return dp[0];
    }
}
