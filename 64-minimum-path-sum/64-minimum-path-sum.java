class Solution {
    public int minFunction(int grid[][], int row, int col, int dp[][]){
        
        //base case
        if(row==0 && col==0)    return dp[row][col]=grid[row][col];
        
        if(dp[row][col]!=0) return dp[row][col];
        
        if(row==0)  return dp[row][col]=grid[row][col] + minFunction(grid, row, col-1, dp);
        if(col==0)  return dp[row][col]=grid[row][col] + minFunction(grid, row-1, col, dp);
        
        return dp[row][col]=grid[row][col] + Math.min(minFunction(grid, row, col-1, dp), minFunction(grid, row-1, col, dp));
        
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        return minFunction(grid, m-1, n-1, dp);
    }
}