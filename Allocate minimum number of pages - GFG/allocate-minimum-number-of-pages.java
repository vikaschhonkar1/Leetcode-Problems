//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public static int findSubarray(int arr[],int maxSum,int M){
        int subarray = 1;
        int sum=0;
        for(int num:arr){
            sum+=num;
            if(sum>maxSum){
                sum=num;
                subarray++;
            }  
        }
       
        return subarray;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[] A, int N, int M){
        if(M>A.length) return -1;
        
        int start = 0;
        int end = 0;
        int ans = 0;
    
        for(int i=0; i<A.length; i++){
            end+=A[i];
            start = Math.max(start, A[i]);
        }
    
        while(start<end){
            int mid = start+(end-start)/2;
            int count = findSubarray(A, mid, M);
            
            if(count<=M) end = mid;
            else start = mid+1;
        }
        return start;
    }
};