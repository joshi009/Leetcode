class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        if (nums.length <= (k << 1) + 1) return nums.length;
        
        Arrays.sort(nums);
        int count = 0;        // number of distinct elements
        int curr = Integer.MIN_VALUE; // last chosen value

        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(curr + 1, nums[i] - k); // smallest value we can pick
            int end = nums[i] + k;                       // largest value we can pick
            
            if (start <= end) {
                count++;      // we can assign a new distinct number
                curr = start; // move to next available number
            }
        }
        return count;
    }
}