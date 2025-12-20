class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int res = 0;

        for (int i = 0; i < m; i++) {
            int x = -1;
            for(String str : strs) {
                int y = str.charAt(i) - 'a';
                if(x > y) {
                    res++;
                    break;
                }
                x = y;
            }
        }
        return res;
    }
}