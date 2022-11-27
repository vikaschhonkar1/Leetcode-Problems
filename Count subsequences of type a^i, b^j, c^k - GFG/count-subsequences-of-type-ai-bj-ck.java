//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        int a = 0;
        int b = 0;
        int c = 0;
        int i = 0;
        int mod = 1000000007;
        
        while(i<s.length()){
            char ch = s.charAt(i++);
            if(ch=='a'){
                a = ((2*a)%mod+1)%mod;
            }else if(ch=='b'){
                b=(a+(b*2)%mod)%mod;
            }else{
                c=((2*c)%mod+b)%mod;
            }
        }
        return c;
    }
}