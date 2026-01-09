import java.util.*;

public class combinationsSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);

        combinations(results, new ArrayList<>(), candidates, target, 0);

        return results;
    }

    private void combinations(List<List<Integer>> results, List<Integer> current, int[] candidates, int target, int start) {

        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early stopping if current candidate > remaining target
            if (candidates[i] > target) break;

            if (i > start && candidates[i] == candidates[i-1]) continue;

            current.add(candidates[i]);
            combinations(results, current, candidates, target - candidates[i], i + 1);

            current.remove(current.size() - 1);
        }
    }
}
