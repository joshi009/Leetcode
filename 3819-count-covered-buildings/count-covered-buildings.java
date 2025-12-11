class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer, Integer> rowMinY = new HashMap<>(); 
        Map<Integer, Integer> rowMaxY = new HashMap<>(); 

        Map<Integer, Integer> colMinX = new HashMap<>(); 
        Map<Integer, Integer> colMaxX = new HashMap<>(); 
        
        
        for (int[] building : buildings) {
            int x = building[0]; 
            int y = building[1]; 
            
            rowMinY.put(x, Math.min(rowMinY.getOrDefault(x, Integer.MAX_VALUE), y));
            rowMaxY.put(x, Math.max(rowMaxY.getOrDefault(x, Integer.MIN_VALUE), y));
            
            colMinX.put(y, Math.min(colMinX.getOrDefault(y, Integer.MAX_VALUE), x));
            colMaxX.put(y, Math.max(colMaxX.getOrDefault(y, Integer.MIN_VALUE), x));
        }

        int coveredCount = 0;

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            boolean hasLeft = (y > rowMinY.get(x));
            boolean hasRight = (y < rowMaxY.get(x));

            boolean hasAbove = (x > colMinX.get(y));
            boolean hasBelow = (x < colMaxX.get(y));
            
            if (hasLeft && hasRight && hasAbove && hasBelow) {
                coveredCount++;
            }
        }

        return coveredCount;
    }
}