import java.util.*;

public class primePairsWithTargetSum {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 4) return ans;

        boolean[] isComposite = new boolean[n+1];

        for (int i = 2; i*i <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <=n; j+=i) {
                    isComposite[j] = true;
                }
            }
        }

        for (int i = 2; i <= n/2; i++) {
            if (!isComposite[i] && !isComposite[n-i] && (i + (n-i) == n)) {
                ans.add(Arrays.asList(i, n-i));
            }
        }

        return ans;
    }
}
