//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.rremove(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    String rremove(String s) {
        // code here
        StringBuilder sb = new StringBuilder(s);
        String newStr = "";

 

 if(s.length()<=1)

 return s;

 

 for(int i =0; i <sb.length()-1; i++)

 {

     int j =i+1;

     boolean k =false;

     while(j<sb.length() && sb.charAt(i)== sb.charAt(j))

     {

         

         sb.deleteCharAt(j);

         k= true;

     }

     if(k)

     {

         sb.deleteCharAt(i);

         i=i-1;            //if we remove the char at i then we need to make sure that we process i+1 element properly. 

     }

     

 }

 

     if(!s.equals(sb.toString()))

     newStr= rremove(sb.toString());

    else 

    newStr = sb.toString();

      return newStr;

    

    }    

 

}