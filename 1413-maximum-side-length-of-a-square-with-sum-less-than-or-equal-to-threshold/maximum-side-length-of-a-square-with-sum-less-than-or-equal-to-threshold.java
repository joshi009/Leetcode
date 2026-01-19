class Solution {

    // private int sum(int[][] mat, int r, int c, int k){
    //     // calc row sum
    //     int rowsum = 0;
    //     for(int i = r; i<r+k; i++){
    //         for(int j = c; j<c+k; j++){
    //              rowsum += mat[i][j];
    //         }
    //     }
    //     return rowsum; 
    // }

      private boolean check(int i, int j, int len, int[][] prefix, int threshold){
        int n = prefix.length - 1;
        int m = prefix[0].length - 1;

        if (i + len - 1 > n || j + len - 1 > m) return false;

        int sum = prefix[i + len - 1][j + len - 1]  - prefix[i - 1][j + len - 1] - prefix[i + len - 1][j - 1]  + prefix[i - 1][j - 1];
        return sum <= threshold;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        // int ans = 0;

        //Brute force approach
        // for(int k=1; k<=Math.min(row, col); k++){
        //     boolean flag = false;
        //     for(int i =0; i <= row -k; i++){
        //         for(int j=0; j<= col -k; j++){
        //             if(sum(mat, i, j,k) <= threshold){
        //                 ans = k;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return ans;

        //Optimal
        int maxi = 0;

        int[][] prefix = new int[n+1][m+1];

        // Build prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j]  + prefix[i][j - 1] - prefix[i - 1][j - 1];                 
            }
        }

         int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int low = 1;
                int high = Math.min(n - i + 1, m - j + 1);

                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    if (check(i, j, mid, prefix, threshold)) {
                        ans = Math.max(ans, mid);
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }

        return ans;

    }
}