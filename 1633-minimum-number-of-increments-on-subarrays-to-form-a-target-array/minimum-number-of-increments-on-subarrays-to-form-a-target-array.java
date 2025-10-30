class Solution 
{
    public int minNumberOperations(int[] nums) 
    {
        int i,res = nums[0];
        for(i=1;i<nums.length;i++)
        {
            res += Math.max(nums[i] - nums[i-1],0);
        }
        return res;
    }
}