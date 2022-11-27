//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        // code here
        int dp[][] = new int[n][m];
        int ans = 0;
        
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(i==n-1 && j==m-1){
                    dp[i][j] = mat[i][j];
                } else if(i==n-1){
                    dp[i][j] = mat[i][j];
                } else if(j==m-1){
                    dp[i][j] = mat[i][j];
                } else{
                    if(mat[i][j]==0){
                        dp[i][j] = 0;
                    } else{
                        dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}