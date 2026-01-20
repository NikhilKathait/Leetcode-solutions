import java.util.*;

public class uniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) return 0;

        int[][] dp = new int[n][m];

        for (int i = 0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return uniquePaths(obstacleGrid, dp, n-1, m-1);
    }

    private int uniquePaths(int[][] obstacleGrid, int[][] dp, int i, int j) {
        if (i < 0 || j < 0) return 0;
        else if (obstacleGrid[i][j] == 1) return 0;
        else if (i == 0 && j == 0) return dp[i][j] = 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = uniquePaths(obstacleGrid, dp, i-1, j) +
                uniquePaths(obstacleGrid, dp, i, j-1);
    }
}
