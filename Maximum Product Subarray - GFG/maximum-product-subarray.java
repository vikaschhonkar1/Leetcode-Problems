// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long minV = arr[0];
        long maxV = arr[0];
        long maxProd = arr[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]<0){
                long temp = minV;
                minV = maxV;
                maxV = temp;
            }
            
            minV = Math.min((long)arr[i]*minV, (long)arr[i]);
            maxV = Math.max((long)arr[i]*maxV, (long)arr[i]);
            
            maxProd = Math.max(maxProd, maxV);
        }
        return maxProd;
        
    }
}