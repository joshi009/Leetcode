class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        int[] dub = new int[2];

        int counter = 0;

        for (int num : nums) {
            if (seen[num]) {
                dub[counter++] = num;
            } else {
                seen[num] = true;
            }

            if (counter == 2) {
                return dub;
            }

        }

        return dub;
    }
}