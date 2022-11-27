//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] minCost = new int[rows][cols];
        for(int[] row: minCost)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        minCost[0][0] = grid[0][0];
        int[][] directions = {{1, 0},{0, 1},{-1, 0},{0, -1}};
        pq.offer(new int[]{0, 0, grid[0][0]});
        
        while(!pq.isEmpty())
        {
            int[] current = pq.poll();
            int cx = current[0], cy = current[1], weight = current[2];
            if(cx == rows - 1 && cy == cols - 1)
                return weight;
            
            for(int k = 0; k < 4; k++)
            {
                int nx = cx + directions[k][0];
                int ny = cy + directions[k][1];
                
                if(nx < 0 || nx == rows) continue;
                if(ny < 0 || ny == cols) continue;
                if(weight + grid[nx][ny] < minCost[nx][ny])
                {
                    minCost[nx][ny] = weight + grid[nx][ny];
                    pq.offer(new int[]{nx, ny, minCost[nx][ny]});
                }
            }
        }
        return minCost[rows-1][cols-1];
        
    }
}