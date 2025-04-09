class Solution {
    public boolean isMatch(String s, String p) {
        return matchHelper(s, p, 0, 0);
    }

    // Brute-force recursive approach (TLE for large inputs)
    private boolean matchHelper(String s, String p, int i, int j) {
        // Base case: both string and pattern are fully matched
        if (j == p.length()) {
            return i == s.length();
        }

        // Check if current characters match
        boolean currentMatch = (i < s.length() &&
            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // Handle '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Option 1: Treat '*' as zero occurrence
            // Option 2: If current matches, consume a char in 's'
            return matchHelper(s, p, i, j + 2) || (currentMatch && matchHelper(s, p, i + 1, j));
        } else {
            // Move one character forward if current match
            return currentMatch && matchHelper(s, p, i + 1, j + 1);
        }
    }
}
