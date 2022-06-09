// { Driver Code Starts
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
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}// } Driver Code Ends


//User function Template for Java
// import java.math.*;
class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        java.math.BigInteger a = new java.math.BigInteger("1");
        for(int i=1; i<=N; i++){
            java.math.BigInteger c = a.multiply(java.math.BigInteger.valueOf(i));
            a = c;
        }
        char arr[] = a.toString().toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
       
        for(int i=0;i<arr.length;i++){
           list.add(arr[i]-'0');
        }
        return list;
     
    }
}