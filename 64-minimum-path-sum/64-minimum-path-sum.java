class Solution {
    
        
    public static int helper(int[][] grid, int xi, int yi, int xf, int yf, int dp[][]){
        if(xi==xf && yi==yf) return grid[xf][yf];
        if(xi>xf || yi>yf) return 50000000;
        if(dp[xi][yi]!=0) return dp[xi][yi];
        int down = grid[xi][yi] + helper(grid, xi+1, yi, xf, yf, dp); 
        int right = grid[xi][yi] + helper(grid, xi, yi+1, xf, yf, dp);
        return dp[xi][yi]=Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        return helper(grid, 0, 0, m-1, n-1, dp);
    }
}