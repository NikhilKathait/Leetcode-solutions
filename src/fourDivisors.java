public class fourDivisors {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int sum = 0;;

        for (int i = 0; i < n; i++) {
            int divisors = 0;
            int tempSum = 0;

            for (int j = 1; j*j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    int other = nums[i] / j;

                    divisors++;
                    tempSum += j;

                    if (other != j) {
                        divisors++;
                        tempSum += other;
                    }

                    if (divisors > 4) break;
                }
            }

            if (divisors == 4) {
                sum += tempSum;
            }
        }

        return sum;
    }
}
