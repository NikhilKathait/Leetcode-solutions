import java.util.*;

public class generateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        paranthesis(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void paranthesis(List<String> result, StringBuilder current,
                             int open, int close, int n) {

        // If current string is complete
        if (current.length() == 2*n) {
            result.add(current.toString());
            return;
        }

        // Add '(' if possible
        if (open < n) {
            current.append("(");
            paranthesis(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }

        // Add ')' if it won't break the balance
        if (close < open) {
            current.append(")");
            paranthesis(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);  // backtrack
        }
    }
}
