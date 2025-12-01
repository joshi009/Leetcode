class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long result = 0;
        long sum = 0;
        for (int i = 0; i < batteries.length - n; i++) {
            sum += batteries[i];
        }

        int start = batteries.length - n;
        int end = batteries.length;

        long left = 0;
        long right = sum + batteries[batteries.length - 1];
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isValid(batteries, start, end, sum, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static boolean isValid(int[] batteries, int start, int end, long sum, long target) {
        for (int i = start; i < end; i++) {
            if (batteries[i] < target) {
                sum -= target - batteries[i];
            }
            if (sum < 0) {
                return false;
            }
        }
        return true;
    }
}