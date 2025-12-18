class Solution{
    public long maxProfit(int[]prices,int[]strategy,int k){
        int n=prices.length;
        int halfK=k>>1;
        long curSum=0;
        for(int i=0;i<n;i++){
            curSum+=(long)strategy[i]*prices[i];
        }
        long res=curSum;
        curSum=0;
        for(int i=0;i<n;i++){
            if(i>=halfK&&i<k){
                curSum+=prices[i];
            }else if(i>=k){
                curSum+=(long)strategy[i]*prices[i];
            }
        }
        if(curSum>res)res=curSum;
        for(int i=k;i<n;i++){
            curSum+=(long)strategy[i-k]*prices[i-k];
            curSum-=prices[i-halfK];
            curSum+=prices[i]-(long)strategy[i]*prices[i];
            if(curSum>res)res=curSum;
        }
        return res;
    }
}