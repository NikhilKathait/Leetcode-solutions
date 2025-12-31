import java.util.*;

public class containsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // If map already has the number and
            // the difference between indices is <= k
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }

            // Update the latest index of the current number
            map.put(nums[i], i);
        }

        // If no such pair found, return false
        return false;
    }
}
