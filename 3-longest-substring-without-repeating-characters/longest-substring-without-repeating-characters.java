import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0; // start of the window

        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);

            // If character is seen and index is within current window
            if (map.containsKey(current) && map.get(current) >= start) {
                // Move the start to one past the last seen index
                start = map.get(current) + 1;
            }

            // Update the last seen index of current character
            map.put(current, end);

            // Calculate window length
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
