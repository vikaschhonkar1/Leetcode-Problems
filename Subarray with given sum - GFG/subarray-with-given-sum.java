//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // List for storing and returing answer
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int i = 0;
        int j = 0;
        int tempSum = 0;
        
        while(i<n && j<n){
            tempSum += arr[j];
            
            if(tempSum==s && i<=j){
                ans.add(i+1);
                ans.add(j+1);
                return ans;
            } 
            
            if(tempSum<s){
                j++;
            } else {
                tempSum -= arr[i];
                tempSum -= arr[j];
                i++;
            }
        }
        
        
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
}