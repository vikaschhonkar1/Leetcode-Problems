//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Node{
    int data;
    Node left;
    Node right;
    Node(int val){
        data = val;
        left = null;
        right = null;
    }
}

class Solution
{
    int i =0;
    
    Node solve(int arr[], int l, int r){
        if(l>r) return null;
        int rootIndx = (l+r)/2;
        Node root = new Node(arr[rootIndx]);
        root.left = solve(arr, l, rootIndx-1);
        root.right = solve(arr, rootIndx+1, r);
        return root;
    }
    
    void preorder(Node root, int arr[]){
        if(root==null)return;
        arr[i++]=root.data;
        preorder(root.left, arr);
        preorder(root.right, arr);
    }
    
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here 
        ArrayList<Integer> list = new ArrayList<>();
        Node root = solve(nums, 0, nums.length-1);
        int arr[]= new int[nums.length];
        preorder(root, arr);
        return arr;
    }
}