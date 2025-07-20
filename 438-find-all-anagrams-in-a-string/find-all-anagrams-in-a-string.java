class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> result = new ArrayList<>();
        if (m < n) return result;

        // Build frequency array for p
        int[] pFreq = new int[26];
        for (int k = 0; k < n; k++) {
            pFreq[p.charAt(k) - 'a']++;
        }

        // Sliding window frequency for s
        int[] window = new int[26];
        int i = 0, j = 0;
        while (j < m) {
            // include s[j]
            window[s.charAt(j) - 'a']++;

            // once window size == n, check and then slide
            if (j - i + 1 == n) {
                // compare
                if (Arrays.equals(window, pFreq)) {
                    result.add(i);
                }
                // remove s[i] as we slide forward
                window[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }

        return result;
    }
}
