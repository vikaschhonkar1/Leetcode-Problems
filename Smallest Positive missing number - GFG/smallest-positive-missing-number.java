// { Driver Code Starts
import java.util.*;


 // } Driver Code Ends


class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        // Your code here
        int freq[] = new int[1000000];
        for(int i=0; i<n; i++){
            if(arr[i]>0){
                freq[arr[i]]++;
            }
        }
        for(int i=1; i<1000000; i++){
            if(freq[i]==0){
                return i;
            }
        }
        return -1;
    }
}


// { Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}

  // } Driver Code Ends