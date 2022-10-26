//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long arr[]=new long[n];
		  long brr[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      arr[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      brr[i]=sc.nextLong();
		  }
		  Solution ob = new Solution();
		  System.out.println(ob.check(arr,brr,n)==true?"1":"0");
		  
		  
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        for(int i=0; i<N; i++){
            if(map.containsKey(A[i])) map.put(A[i], map.get(A[i])+1);
            else map.put(A[i], 1);
        }
        for(int i=0; i<N; i++){
            if(!map.containsKey(B[i])){
                return false;
            } else if(map.get(B[i])==0){
                return false;
            }
            if(map.containsKey(B[i])) map.put(B[i], map.get(B[i])-1);
        }
        return true;
    }
}