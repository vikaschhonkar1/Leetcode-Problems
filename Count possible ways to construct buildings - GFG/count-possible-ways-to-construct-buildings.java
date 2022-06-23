// { Driver Code Starts
//Initial Template for Java

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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        long ans = 0;
        long a = 0;
        long b = 1;
        long M = 1000000000+7;
        for(int i=2; i<=N+2; i++){
            long c = (a+b)%M;
            a = b;
            b = c;
            ans = c;
        }
        ans = (ans*ans)%M;
        return (int)ans;
    }
}