public class ransomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (int i = 0; i< magazine.length(); i++) {
            char ch = magazine.charAt(i);

            freq[ch - 'a']++;
        }

        for (int j = 0; j<ransomNote.length(); j++) {
            char ch = ransomNote.charAt(j);

            if (freq[ch - 'a']-- == 0) {
                return false;
            }
        }

        return true;
    }
}
