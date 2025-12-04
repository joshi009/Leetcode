class Solution {
    public int countCollisions(String dir) {
        int n = dir.length();
        int sub = 0,sCount = 0;

        for(int i = 0; i < n; i++) {
            char ch = dir.charAt(i);

            if(ch != 'L') {
                break;
            }
            sub++;
        }

        for(int i = n-1; i >= 0; i--) {
            char ch = dir.charAt(i);

            if(ch != 'R') {
                break;
            }
            sub++;
        }

        for(int i = 0; i < n; i++) {
            char ch = dir.charAt(i);

            if(ch == 'S') {
                sCount++;
            }
        }
        return (n - sub - sCount);
    }
}