class Solution {
    public  int[] searchRange(int[] nums, int target) {
    int first= search(nums,target,true);
    int sec=search(nums,target,false);
    return new int[]{first,sec};
    }
    public int search(int[] nums, int target,boolean isfirst) {
         int start = 0;
        int end = nums.length - 1;
        int ans=-1;
        while (start <=end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid - 1;
            else {
                ans=mid;
                if(isfirst)
                {
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return ans;


    }
}