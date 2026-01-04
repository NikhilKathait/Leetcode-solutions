import java.util.*;

public class pascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // first element is always 1
            row.add(1);

            for (int j = 1; j < i; j++) {
                // Pascal rule: nCk = (n-1Ck-1 + n-1Ck)
                int val = result.get(i-1).get(j-1)
                        + result.get(i-1).get(j);

                row.add(val);
            }

            // Last elemet is always 1
            if (i > 0) {
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }
}
