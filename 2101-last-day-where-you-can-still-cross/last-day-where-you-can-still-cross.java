class Solution {
    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        boolean[][] visited = new boolean[row][col];
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0 && !visited[0][c]) {
                if (dfs(grid, visited, 0, c)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
            grid[r][c] == 1 || visited[r][c]) return false;

        if (r == grid.length - 1) return true;

        visited[r][c] = true;
        for (int[] d : directions) {
            if (dfs(grid, visited, r + d[0], c + d[1])) return true;
        }
        return false;
    }
}