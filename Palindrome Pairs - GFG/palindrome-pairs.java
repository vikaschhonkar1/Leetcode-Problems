//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = new String[N];
            
            for(int i=0; i<N; i++)
                arr[i] = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.palindromepair(N,arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    boolean check(String s,int start,int end) {
        while(start<end) {
            if(s.charAt(start)==s.charAt(end)) {
                start++;
                end--;
            }
            else
            return false;
        }
        return true;
    }
    
    String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,temp);
            i++;
            j--;
        }
        return sb.toString();
    }
    
    int palindromepair(int N, String arr[]) {
        // code here
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            String rev = rev(arr[i]);
            map.put(rev, i);
        }
        
        for(int i=0;i<arr.length;i++) {
            String str = arr[i];
            
            if(map.containsKey(str)&&map.get(str)!=i) return 1;
            
            for(int j=0; j<str.length()-1; j++) {
                if(check(str, 0, j)) {
                    if(map.containsKey(str.substring(j+1)))
                    if(map.get(str.substring(j+1))!=i)
                    return 1;
                }
                
                if(check(str,j+1,str.length()-1)) {
                    if(map.containsKey(str.substring(0,j+1)))
                    if(map.get(str.substring(0,j+1))!=i)
                    return 1;
                }
            }
        }
        return 0;
    }
}