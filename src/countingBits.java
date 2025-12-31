public class countingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;

        int i = 1;
        while (i <= n) {
            ans[i] = ans[i >> 1] + (i & 1);
            i++;
        }

        return ans;
    }
}
