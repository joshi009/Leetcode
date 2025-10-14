class Solution 
{
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) 
    {
        int n=nums.size();
        for(int i=0;i<=n-2*k;i++)
        {
            if(isIncreasing(i,k,nums)&&isIncreasing(i+k,k,nums))
                return true;
        }
        return false;
    }
    public static boolean isIncreasing(int start,int k,List<Integer> arr)
    {
        for(int i=start;i<start+k-1;i++)
        {
            if(arr.get(i)>=arr.get(i+1))
                return false;
        }
        return true;
    }
}