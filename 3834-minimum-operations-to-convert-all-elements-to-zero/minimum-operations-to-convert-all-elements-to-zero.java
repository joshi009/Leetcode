class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int op = 0;

        for (int val : nums) {

            while (!st.isEmpty() && st.peek() > val)
                st.pop();

            if (val == 0) {
                st.clear();
                continue;
            }

            if (st.isEmpty() || val > st.peek()) {
                st.push(val);
                op++;
            }
        }

        return op;
    }
}