//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int getBeauty(int l, String s, int n){
        int freq[] = new int[26];
        int ans = 0;
        for(int i=l; i<n; i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            
            for(int j=0; j<26; j++){
                if(freq[j]>0){
                    if(min>freq[j]) min = freq[j];
                    if(max<freq[j]) max = freq[j];
                }
            }
            ans += max - min;
        }
        return ans;
    }
    
    public static int beautySum(String str) {
        int ans = 0;
        for(int i=0; i<str.length(); i++) ans += getBeauty(i, str, str.length());
        return ans;
    }
}
        
