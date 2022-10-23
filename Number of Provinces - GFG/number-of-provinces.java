//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void bfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            Integer x = q.poll();
            for(Integer it: adj.get(x)){
                if(!visited[it]){
                    visited[it] = true;
                    q.add(it);
                }
            }
        }
    }
    
    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for(Integer it: adj.get(node)){
            if(!visited[it]){
                visited[it] = true;
                dfs(it, visited, adj);
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean visited[] = new boolean[V+5];
        int count = 0;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        for(int i=0; i<V; i++){
            if(!visited[i]){
                count++;
                dfs(i, visited, adjList);
            }
        }
        return count;
     }
};