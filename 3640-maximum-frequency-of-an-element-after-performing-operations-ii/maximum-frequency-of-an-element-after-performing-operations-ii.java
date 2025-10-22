class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Arrays.sort( nums );

        int i = 0;
        int left = 0;
        int right = 0;

        int ans = 0;

        while ( i < n ) {
            int val = nums[i];
            int same = 0;
            while ( i < n && nums[i] == val ) {
                i++;
                same++;
            }

            int rightBound = val + k;
            while ( right < n && nums[right] <= rightBound ) {
                right++;
            }

            int leftBound = val - k;
            while ( left < n && nums[left] < leftBound ) {
                left++;
            }

            ans = Math.max( ans, same + Math.min( numOperations, right - left - same ) );
        }

        left  = 0;
        right = 0;
        long tempK = 2L*k;
        while ( right < n ) {
            while ( right < n && tempK + nums[left] >= nums[right] ) {
                right++;
            }
            ans = Math.max( ans, Math.min( numOperations, right - left ) );
            left++;
        }

        return ans;
    }
}