class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int consecutiveh = 1;
        int consecutivev = 1;
        int currconsecutiveh = 1;
        for (int i = 1; i < hBars.length ; i++) {
            if (hBars[i] - hBars[i-1] == 1 ) {
                currconsecutiveh++;
            } else {
                currconsecutiveh = 1;
            }
            consecutiveh = Math.max(currconsecutiveh, consecutiveh);
        }
        int currconsecutivev = 1;
        for (int i = 1; i < vBars.length ; i++) {
            if (vBars[i ] - vBars[i -1 ] == 1) {
                currconsecutivev++;
            } else {
                currconsecutivev = 1;
            }
            consecutivev = Math.max(currconsecutivev, consecutivev);
        }
        int side = Math.min(consecutiveh, consecutivev) +1;
        return side * side;
    }
}