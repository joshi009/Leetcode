class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] mod = new int[value];

        for (int x : nums) {
            int r = ((x % value) + value) % value;
            mod[r]++;
        }

        for (int i = 0; i <= n; i++) {
            int j = i % value;
            mod[j]--;
            if (mod[j] < 0) return i;
        }

        return n;
    }
}