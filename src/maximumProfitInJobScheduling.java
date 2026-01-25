import java.util.*;

public class maximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        // jobs[i] = {start, end, profit}
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort by end time
        Arrays.sort(jobs, (x,y) -> Integer.compare(x[1], y[1]));

        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int include = jobs[i][2];
            int l = binarySearch(jobs, i);

            if (l != -1) {
                include += dp[l];
            }

            dp[i] = Math.max(dp[i - 1], include);
        }

        return dp[n - 1];
    }

    // Find the last job that doesn't conflict with job[index]
    private int binarySearch(int[][] jobs, int index) {
        int low = 0, high = index - 1;
        int targetStart = jobs[index][0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (jobs[mid][1] <= targetStart) {
                if (mid == high || jobs[mid + 1][1] > targetStart) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
