class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int mx = 0;

        while (left < right) {
            mx = Math.max(mx, nums[left] + nums[right]);
            left++;
            right--;
        }
        return mx;
    }
}