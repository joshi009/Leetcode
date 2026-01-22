import java.util.*;
class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int[] arr = Arrays.copyOf(nums, n);
        int ops = 0;
        
        while (true) {
            int len = n - ops;
            boolean sorted = true;
            
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;
            
            int minSum = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < len - 1; i++) {
                int sum = arr[i] + arr[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            
            arr[idx] = minSum;
            for (int i = idx + 1; i < len - 1; i++) {
                arr[i] = arr[i + 1];
            }
            ops++;
        }
        return ops;
    }
}