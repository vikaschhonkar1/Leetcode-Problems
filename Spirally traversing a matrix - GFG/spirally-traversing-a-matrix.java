// { Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        int turn = 0;
        int i_max = r - 1;
        int i_min = 0;
        int j_max = c - 1;
        int j_min = 0;
        int i = 0;
        int j = 0;
        for (i = 0, j = 0; i_min <= i_max && j_min <= j_max;) {
            if (turn % 4 == 0) {
                list.add(matrix[i][j]);
                j++;
                if (j > j_max) {
                    turn++;
                    i_min++;
                    j--;
                    i++;
                }
            } else if (turn % 4 == 1) {
                list.add(matrix[i][j]);
                i++;
                if (i > i_max) {
                    turn++;
                    j_max--;
                    i--;
                    j--;
                }
            } else if (turn % 4 == 2) {
                list.add(matrix[i][j]);
                j--;
                if (j < j_min) {
                    turn++;
                    i_max--;
                    j++;
                    i--;
                }
            } else {
                list.add(matrix[i][j]);
                i--;
                if (i < i_min) {
                    turn++;
                    j_min++;
                    i++;
                    j++;
                }
            }
        }
        return list;
    }
}
