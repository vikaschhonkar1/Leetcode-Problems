//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        HashSet<String> set = new LinkedHashSet<String>();
        for(int i=0; i<n; i++) set.add(contact[i]);
        
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        char ch[] = s.toCharArray();
        String tempString = "";
        
        for(int i=0; i<ch.length; i++){
            tempString+=ch[i];
            
            ArrayList<String> rowList = new ArrayList<String>();
            
            for(String str: set){
                if(str.contains(tempString)) rowList.add(str);
            }
            
            if(rowList.size()==0) rowList.add("0");
            
            Collections.sort(rowList);
            list.add(rowList);
        }
        
        return list;
    }
}