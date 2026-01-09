import java.util.*;

public class letterCombinationsOfAPhoneNumber {
    // Map of digits to respective letters
    private static final String[] KEYPAD = {
            "",     // 0 - no mapping
            "",     // 1 - no mapping
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Return empty list if digits is empty
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, new StringBuilder(), digits, 0);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base case: if the current length matches digits length, add to results
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters mapped to the current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];

        // Traverse each mapped letter
        for (char letter : letters.toCharArray()) {
            // Append the letter to current combination
            current.append(letter);

            // Move to the next digit
            backtrack(result, current, digits, index + 1);

            // Backtrack by removing the last letter added
            current.deleteCharAt(current.length() - 1);
        }
    }
}
