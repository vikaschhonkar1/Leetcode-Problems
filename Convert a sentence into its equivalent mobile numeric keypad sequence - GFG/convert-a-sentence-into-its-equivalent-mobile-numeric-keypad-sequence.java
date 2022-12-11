//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String S = read.readLine();
            Solution obj = new Solution();
            System.out.println(obj.printSequence(S));
            
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String printSequence(String S) 
    { 
        // code here
        String ans="";
        int base=0, rep=0, add=0 ,digit;
        
        for(int i=0;i< S.length();i++ ){
            char temp = S.charAt(i);
            
            if(temp==' '){
                ans+=String.valueOf(0);
                continue;
            } else if(temp == 'S' ||temp == 'V' ||temp == 'Y' ||temp == 'Z' ){
                add=1;
            } else{
                add =2;
            }
            
            int d=temp-65;
            base=(temp-65)/3;
            digit= base+add;
            rep=(temp-65)%3;
            
            if(temp=='T'|| temp=='U'|| temp=='W'|| temp=='X'){
                rep-=1;
            } else if(temp=='V'||temp=='Y'||temp=='Z') {
                rep+=2;
            } else if(temp== 'S'){
                rep+=3;
            }
            
            int j=0;
            while(j<=rep){
                ans+= Integer.toString(digit);
                j++;
            }
        }
        return ans;
    }
}