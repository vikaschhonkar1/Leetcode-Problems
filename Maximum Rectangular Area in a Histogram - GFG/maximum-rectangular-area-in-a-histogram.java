//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution{
    static long[] prevSmaller(long[] hist, long n){
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        long prev[] = new long[hist.length];
        for(int i=0; i<hist.length; i++){
            while(st.peek()!=-1 && hist[st.peek()]>=hist[i]) st.pop();
            prev[i] = st.peek();    
            st.push(i);    
        }
        return prev;
    }
    
    static long[] nextSmaller(long[] hist, long n){      
        Stack<Integer> st = new Stack<>();
        st.push(hist.length);
        long[] next = new long[hist.length];
        for(int i=hist.length-1; i>=0; i--){
            while(st.peek()!=hist.length && hist[st.peek()]>=hist[i]) st.pop();
            next[i] = st.peek();
            st.push(i);
        }
        return next;
    }
    
    public static long getMaxArea(long hist[], long n){
        long maxArea = Integer.MIN_VALUE;
        long[] prevSmaller = prevSmaller(hist,n);
        long[] nextSmaller = nextSmaller(hist,n);

        for(int i=0; i<hist.length; i++){
            long currArea = (nextSmaller[i]-prevSmaller[i]-1) * hist[i];
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}


