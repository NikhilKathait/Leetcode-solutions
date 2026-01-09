import java.util.*;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generate(nums, ans, curr, 0);

        return ans;
    }

    private void generate(int[] nums, List<List<Integer>> ans,
                          List<Integer> curr, int idx) {
        // Add the current subset
        ans.add(new ArrayList<>(curr));

        // Generate all next subsets
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);                      // choose
            generate(nums, ans, curr, i + 1);     // recurse
            curr.remove(curr.size() - 1);           // un-choose
        }
    }
}
