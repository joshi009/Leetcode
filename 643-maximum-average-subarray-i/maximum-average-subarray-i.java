class Solution {
    public double findMaxAverage(int[] nums, int k) {
    int i = 0;
    int j=0;
    int sum=0;
    int maxsum=Integer.MIN_VALUE;
    while(j<nums.length)
    {
        sum+=nums[j];
        if(j-i+1==k)
        {
            maxsum=Math.max(maxsum,sum);
            //move the window
            sum-=nums[i];
            i++;
            
        }
        j++;
    }
    return (double)maxsum/k;
        
    }
}