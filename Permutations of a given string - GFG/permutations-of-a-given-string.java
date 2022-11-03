//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    public void solve(List<String> ans, String str, String sub, boolean freq[], int idx){
        if(sub.length()==str.length()){
            if(!ans.contains(sub)) ans.add(sub);
            return;
        }

        for(int i=0; i<str.length(); i++){
            if(!freq[i]){
                freq[i]=true;
                sub+=str.charAt(i);
                solve(ans, str, sub, freq, 0);
                sub = sub.substring(0, sub.length()-1);
                freq[i]=false;
            }
        }
    }
    public List<String> find_permutation(String S) {
        ArrayList<String> ans = new ArrayList<String>();
        String sub = "";
        boolean freq[] = new boolean[S.length()]; 
        solve(ans, S, sub, freq, 0);
        Collections.sort(ans);
        return ans;
    }
}