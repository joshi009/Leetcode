class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] ch = s.toCharArray();

        int last[] = new int[26]; Arrays.fill(last, -1);
        for(int i=0; i<ch.length; i++) last[ch[i]-'a'] = i;

        int cnt[] = new int[26], firstCnt[][] = new int[26][26];
        boolean filled[] = new boolean[26];
        int ans = 0;
        for(int i=0; i<ch.length; i++){
            int idx = ch[i]-'a'; cnt[idx]++;
            if(!filled[idx]){
                System.arraycopy(cnt, 0, firstCnt[idx], 0, 26);
                filled[idx] = true;
            } else if (last[idx] == i){
                for(int x=0; x<26; x++){
                    if(x != idx && (cnt[x] - firstCnt[idx][x]) > 0) ans++;
                    else if(x == idx && (cnt[x] - firstCnt[idx][x]) > 1) ans++;
                }
            }
        }
        return ans;
    }
}