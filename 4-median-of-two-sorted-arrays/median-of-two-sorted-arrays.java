import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Brute-force: merge without caring about sort order
        int n = nums1.length;
        int m = nums2.length;
        int[] combined = new int[n + m];

        for (int i = 0; i < n; i++) {
            combined[i] = nums1[i];
        }
        for (int j = 0; j < m; j++) {
            combined[n + j] = nums2[j];
        }

        // Inefficient sort (for large inputs this may TLE)
        Arrays.sort(combined);

        int total = combined.length;
        if (total % 2 == 1) {
            return (double) combined[total / 2];
        } else {
            return ((double) combined[total / 2 - 1] + (double) combined[total / 2]) / 2.0;
        }
    }
}
