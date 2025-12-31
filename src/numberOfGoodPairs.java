import java.util.*;

public class numberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {

            // If number is already seen,
            // it can form pairs with all previous occurrences
            if (map.containsKey(num)) {

                // Increment count by the number of occurrences seen so far
                count += map.get(num);

                // Increment the occurrence count in the map
                map.put(num, map.get(num) + 1);
            } else {
                // If number is seen for the first time, put it in the map
                map.put(num, 1);
            }
        }

        return count;
    }
}
