class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] arr = new int[n];
        int roads_n = roads.length;
        for(int i = 0; i < roads_n; i++) {
            int u = roads[i][0];
            int v = roads[i][1];

            arr[u]++;
            arr[v]++;

            connected[u][v] = true;
            connected[v][u] = true;

        }
        int maxRank = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int currRank = arr[i] + arr[j];

                if(connected[i][j]) {
                    currRank--;
                }
            
                maxRank = Math.max(maxRank, currRank);
            }    
        } 
        return maxRank;
    }
}