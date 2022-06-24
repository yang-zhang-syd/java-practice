import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for(var s : strs) {
            var key = toAnagramKey(s);
            if(!anagrams.containsKey(key)) {
                anagrams.put(key, new LinkedList<String>());
            }
            anagrams.get(key).add(s);
        }

        return anagrams.values().stream().toList();
    }

    private String toAnagramKey(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);

        return String.valueOf(chars);
    }
}