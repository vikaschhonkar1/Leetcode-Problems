//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}
// } Driver Code Ends


class Solution
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b)
    {
        
        // Your code here
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        for(int i=0; i<a.length(); i++) freq1[a.charAt(i)-'a']++;
        for(int i=0; i<b.length(); i++) freq2[b.charAt(i)-'a']++;
        
        for(int i=0; i<26; i++){
            if(freq1[i]!=freq2[i]) return false;
        }
        return true;
    }
}