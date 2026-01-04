import java.util.*;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 3) return 0;

        // Initial sum
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n-2; i++) {
            int l = i+1, r = n-1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                // Update closest sum
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    // exact match
                    return sum;
                }
            }
        }

        return closest;
    }
}
