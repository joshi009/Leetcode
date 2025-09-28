class Solution {
    public int largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];
            if (b + c > a) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // You can take input from user or platform here
        // Example: Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt(); int[] nums = new int[n]; ...
        
        // For now, leaving main empty as requested
    }
}

       