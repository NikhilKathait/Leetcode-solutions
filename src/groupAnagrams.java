import java.util.*;

public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!sMap.containsKey(key)) {
                sMap.put(key, new ArrayList<>());
            }

            sMap.get(key).add(str);
        }

        return new ArrayList<> (sMap.values());
    }
}
