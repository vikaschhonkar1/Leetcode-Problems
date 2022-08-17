class Solution {
    private static int ans = 0;
    
    private static int area(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0)
            return 0;
        
        ans++;
        grid[row][col] = 0;
        
        area(grid, row - 1, col);
        area(grid, row + 1, col);
        area(grid, row, col - 1);
        area(grid, row, col + 1);
        
        return ans;
    }

    private static int maxArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    res = Math.max(res, area(grid, i, j));
                    ans = 0;
                }
            }
        }
        return res;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        return maxArea(grid);
    }
}