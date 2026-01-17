class Solution {

    private long overlapSquareArea(
        int ax1, int ay1, int ax2, int ay2,
        int bx1, int by1, int bx2, int by2
    ) {
        int w = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        if (w <= 0) return 0;

        int h = Math.min(ay2, by2) - Math.max(ay1, by1);
        if (h <= 0) return 0;

        int side = Math.min(w, h);
        return (long) side * side;
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long max = 0;

        for (int i = 0; i < n; i++) {
            int ax1 = bottomLeft[i][0];
            int ay1 = bottomLeft[i][1];
            int ax2 = topRight[i][0];
            int ay2 = topRight[i][1];

            for (int j = i + 1; j < n; j++) {
                long area = overlapSquareArea(
                    ax1, ay1, ax2, ay2,
                    bottomLeft[j][0], bottomLeft[j][1],
                    topRight[j][0], topRight[j][1]
                );

                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }
}