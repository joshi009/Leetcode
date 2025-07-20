class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> result = new ArrayList<>();
        if (m < n) return result;

        // 1) Build frequency array for p
        int[] pFreq = new int[26];
        for (int i = 0; i < n; i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        // 2) Sliding window freq over s
        int[] window = new int[26];
        // initialize first window of size n−1
        for (int i = 0; i < n - 1; i++) {
            window[s.charAt(i) - 'a']++;
        }

        // now slide, adding one char at right and removing one at left each time
        for (int i = n - 1, left = 0; i < m; i++, left++) {
            // include s[i]
            window[s.charAt(i) - 'a']++;

            // check for anagram match
            if (Arrays.equals(window, pFreq)) {
                result.add(left);
            }

            // remove s[left] to slide window
            window[s.charAt(left) - 'a']--;
        }

        return result;
    }
}
