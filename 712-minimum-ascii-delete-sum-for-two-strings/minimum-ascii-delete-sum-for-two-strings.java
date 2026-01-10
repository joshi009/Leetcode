class Solution {
    public int ascii(String s, int x){
        int sum = 0;
        while(x<s.length()){
            sum += s.charAt(x);
            x++;
        }
        return sum;
    }
    public int minimumDeleteSum(String s1, String s2) {
        // Variation of LCS
        int n = s1.length();
        int m = s2.length();

        // Memoization
        // Integer[][] dp = new Integer[n][m]; 
        // return solve(s1, s2, 0, 0, dp);


        // Tabulation
        int[][] dp = new int[n+1][m+1];

        // base initialization
        for(int i=0; i<n+1; i++){
            dp[i][m] = ascii(s1, i);
        }
        for(int j=0; j<m+1; j++){
            dp[n][j] = ascii(s2, j);
        }

        // transition 
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                if(ch1==ch2){ // char matches
                    dp[i][j] = dp[i+1][j+1];
                }else{ // mismatch
                    int a = s1.charAt(i) + dp[i+1][j]; // delete ith char from s1
                    int b = s2.charAt(j) + dp[i][j+1]; // delete jth char from s2
                    dp[i][j] = Math.min(a, b); // go with min
                }
            }
        }
        return dp[0][0]; // min ascii to be deleted starting from index (0, 0)
    }
}