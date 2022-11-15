//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.longestPerfectPiece(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int longestPerfectPiece(int[] arr, int N) {
        // code here
        int j = 0;
        int i = 0;
        int maxLeng  = Integer.MIN_VALUE;

        while (j<arr.length){
            if (Math.abs(arr[i]-arr[j])<=1){
                maxLeng = Math.max(maxLeng, j-i+1);
                j++;
            }else {
                while (Math.abs(arr[i]-arr[j])>1) i++;
            }
        }

        return maxLeng;
    }
};