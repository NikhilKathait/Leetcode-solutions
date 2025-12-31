public class isomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] sfreq = new int[256];
        int[] tfreq = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if previous mapped characters are same
            if (sfreq[charS] != tfreq[charT])
                return false;

            // Map characters to index+1 to avoid default 0 confusion
            sfreq[charS] = i+1;
            tfreq[charT] = i+1;
        }

        return true;
    }
}
