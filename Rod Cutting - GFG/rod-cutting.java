//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]= new int[price.length][n+1];
        
        for(int i=0;i<=n;i++) dp[0][i] = i*price[0];

        for(int i=1; i<price.length; i++){
            for(int target=0; target<=n; target++){
                int notPick = dp[i-1][target];
                int pick = (int)Math.pow(-10,9);

                if(i+1<=target)
                    pick= price[i]+ dp[i][target-(i+1)];

                dp[i][target] = Math.max(pick, notPick);
            }
        }
        return dp[price.length-1][n];
    }
}