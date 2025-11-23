class Solution {
    private int helper(int idx, int[] nums, int mod, int[][] dp){
        if(idx == nums.length) return (mod==0) ? 0 : Integer.MIN_VALUE;

        if(dp[idx][mod]!=-1) return dp[idx][mod];

        int take = nums[idx] + helper(idx+1,nums,((mod+nums[idx])%3),dp);
        int notTake =  helper(idx+1,nums,mod,dp);
        return dp[idx][mod] = Math.max(take,notTake);
        
    }
    public int maxSumDivThree(int[] nums) {
        
        int dp[][] = new int[nums.length+1][3];
        for(int i=0;i<=nums.length;i++){
           for(int j=0;j<3;j++){
            dp[i][j]=-1;
           }
        }
        
        return helper(0,nums,0,dp);
    }
}