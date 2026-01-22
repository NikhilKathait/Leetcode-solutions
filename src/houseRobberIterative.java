public class houseRobberIterative {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev2 = 0;
        int prev1 = 0;

        for (int j = 0; j < n; j++) {
            int temp = Math.max(prev1, nums[j] + prev2);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
}
