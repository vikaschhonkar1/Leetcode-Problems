//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int N=sc.nextInt();
                    String S=sc.next();
                        
                    Solution obj = new Solution();
                    
                    
                    System.out.println(obj.CountPS(S,N));
                    
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean isP(String s){
        if(s.length()==0 || s.length()==1) return true;
        
        if(s.length()==2){
            if(s.charAt(0) == s.charAt(1)) return true;
            else return false;
        }
        
        if(s.charAt(0)==s.charAt(s.length()-1))
            return isP(s.substring(1, s.length()-1));
        else 
            return false;
    }
    
    public int CountPS(String S, int N)
    {
        int count = 0;
        for (int i=0; i<N; i++){
            int j = i + 1;
            while(j<N) {
                if(S.charAt(i)==S.charAt(j)) {
                    if(isP(S.substring(i, j + 1))){
                        count++;
                    }
                }
                j++;
            }
        }
        return count;
    }
}