class Solution {

    

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;

        Integer dp[] = new Integer[n];

        int max = Integer.MIN_VALUE;

        //Tabulation
        for(int i=n-1;i>=0;i--){
            dp[i] = energy[i];
            if(i+k<n)
                dp[i] += dp[i+k];
            max = Math.max(dp[i],max);
        }

        // Recursion + Memoization
        // for(int i=0;i<n;i++){
        //     int pts = dfs(energy,n,i,k);
        //     max = Math.max(max,pts);
        // }

        return max;
    }

    // Recursion + Memoization
    // private int dfs(int energy[],int n,int i,int k){
    //     if(i >= n)
    //         return 0;
        
    //     if(dp[i] != null)
    //         return dp[i];

    //     dp[i] = energy[i];

    //     dp[i] += dfs(energy,n,i+k,k);

    //     return dp[i];
    // }
}