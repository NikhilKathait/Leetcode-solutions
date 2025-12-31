public class maximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        // Frequence array
        int[] count = new int[26];

        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        // Count the minimum balloons
        int minBalloons = Integer.MAX_VALUE;

        // Check for all required characters
        minBalloons = Math.min(minBalloons, count['b' - 'a']);
        minBalloons = Math.min(minBalloons, count['a' - 'a']);
        minBalloons = Math.min(minBalloons, count['l' - 'a'] / 2);
        minBalloons = Math.min(minBalloons, count['o' - 'a'] / 2);
        minBalloons = Math.min(minBalloons, count['n' - 'a']);

        return minBalloons;
    }
}
