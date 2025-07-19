class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[256]; // ASCII size
        // Initialize all indices as -1 (not seen)
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int maxLen = 0;
        int start = 0; // start of current window

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            // If character seen before and in current window
            if (lastIndex[ch] >= start) {
                start = lastIndex[ch] + 1;
            }

            // Update last seen index of the character
            lastIndex[ch] = end;

            // Update max length
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
