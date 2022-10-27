import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
	        
	        for(int i=0; i<n/2; i++){
	            swap(arr, i, n-i-1);
	        }
	        
	        for(int i=0; i<n; i++) System.out.print(arr[i]+" ");
	        System.out.println();
	    }
	    sc.close();
	 }
}