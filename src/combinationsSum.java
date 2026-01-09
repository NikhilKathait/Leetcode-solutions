import java.util.*;

public class combinationsSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        // Start the backtracking process with an empty list and the full target
        combinations(candidates, target, 0, new ArrayList<>(), results);

        return results;
    }

    private void combinations(int[] candidates, int target, int start,
                              List<Integer> current, List<List<Integer>> result) {

        // If target is 0, we found a combination that sums up to the original target
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // If the candidate is greater than the remaining target, there's no point in continuing
            if (candidates[i] > target) continue;

            // Include candidates[i] in the current combination
            current.add(candidates[i]);

            // Continue exploring with the reduced target
            combinations(candidates, target - candidates[i], i, current, result);

            // Backtrack and try the next candidate
            current.remove(current.size() - 1);
        }
    }
}
