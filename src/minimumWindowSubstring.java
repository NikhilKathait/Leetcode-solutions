public class minimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];

        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int count = t.length();
        int minLength = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int start = 0;

        while (r < s.length()) {
            char rch =  s.charAt(r);

            if (need[rch] > 0) {
                count--;
            }

            need[rch]--;
            r++;

            while (count == 0) {
                if (r - l < minLength) {
                    start = l;
                    minLength = r - l;
                }

                char lch = s.charAt(l);
                need[lch]++;

                if (need[lch] > 0) {
                    count++;
                }

                l++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}
