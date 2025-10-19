class Solution {
    public String findLexSmallestString(String str, int addVal, int rotStep) {
        char[] s = str.toCharArray();
        int n = s.length;
        char[] temp = new char[n];
        int step = gcd(rotStep, n);
        int group = gcd(addVal, 10);
        String res = null;

        for (int i = 0; i < n; i += step) {
            // temp = s[i:n] + s[0:i] → rotation
            System.arraycopy(s, i, temp, 0, n - i);
            System.arraycopy(s, 0, temp, n - i, i);

            // Add operation on odd indices
            addDigits(temp, 1, group);

            // If step is odd → we can also change even indices
            if (step % 2 != 0) {
                addDigits(temp, 0, group);
            }

            String curr = new String(temp);
            if (res == null || curr.compareTo(res) < 0) {
                res = curr;
            }
        }

        return res;
    }

    // Perform the add operation starting from index 'start' (0 for even, 1 for odd)
    private void addDigits(char[] arr, int start, int group) {
        int digit = arr[start] - '0';
        int inc = digit % group - digit + 10; // find smallest reachable value
        for (int i = start; i < arr.length; i += 2) {
            arr[i] = (char) ('0' + (arr[i] - '0' + inc) % 10);
        }
    }

    // Compute gcd (greatest common divisor)
    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}