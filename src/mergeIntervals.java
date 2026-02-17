import java.util.*;

public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 1;

        int curr_st = intervals[0][0];
        int curr_en = intervals[0][1];

        while (i < n) {
            if (intervals[i][0] <= curr_en) {
                curr_en = Math.max(curr_en, intervals[i][1]);
            } else {
                result.add(new int[] {curr_st, curr_en});
                curr_st = intervals[i][0];
                curr_en = intervals[i][1];
            }
            i++;
        }

        result.add(new int[] {curr_st, curr_en});
        return result.toArray(new int[result.size()][]);
    }
}
