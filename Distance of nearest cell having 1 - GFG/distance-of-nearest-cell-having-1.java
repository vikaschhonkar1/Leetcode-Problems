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
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}




class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0)
                    ans[i][j] = 501;
            }
        }
        
        for(int x=0; x<=n+m-2; x++){
            int count = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(ans[i][j] == x){
                        if(i>0 && ans[i-1][j] > x+1){
                            count++;
                            ans[i-1][j] = x+1;
                        }
                        if(i+1<n && ans[i+1][j] > x+1){
                            count++;
                            ans[i+1][j] = x+1;
                        }
                        if(j>0 && ans[i][j-1] > x+1){
                            count++;
                            ans[i][j-1] = x+1;
                        }
                        if(j+1<m && ans[i][j+1] > x+1){
                            count++;
                            ans[i][j+1] = x+1;
                        }
                    }
                }
            }
            if(count == 0)
                return ans;
        }
            
        return ans;
    }
}


