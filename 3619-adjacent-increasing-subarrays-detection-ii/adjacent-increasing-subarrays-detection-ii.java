class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int inc = 1, prev = 0, k = 0;

        for(int i = 1; i < n; i++) {
            if(nums.get(i) > nums.get(i - 1)) inc++;
            else {
                prev = inc;
                inc = 1;
            }
            k = Math.max(inc / 2, k); 
            k = Math.max(k, Math.min(inc , prev));
        }
        return k;
    }
}