class Solution {
    public int maxOperations(String s) {
        char[] arr = s.toCharArray();
        int j = arr.length - 1, ans = 0, op = 0;
        
        for(int i = arr.length - 2; i >= 0; --i){
            int curr = arr[i] - '0', next = arr[i + 1] - '0';
            ans += curr * (op + 1 - next);
            op += curr * (1 - next);
        }

        return ans;
    }
}