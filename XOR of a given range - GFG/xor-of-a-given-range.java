// { Driver Code Starts

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
            int a = Integer.parseInt(s[1]);
            int b = Integer.parseInt(s[2]);
            String[] s1 = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)nums[i] = Integer.parseInt(s1[i]);
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            Solution obj = new Solution();
            int ans = obj.getXor(nums, a, b);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Solution{
    public int getXor(int[] arr, int a, int b){
        // Code here 
        int ans = arr[a];
        for(int i=a+1; i<=b; i++){
            ans=ans^arr[i];
        }
        return ans;
    }
}