class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sum %= 2;
        }
        return sum == 1 ? 0 : nums.length - 1;
    }
}