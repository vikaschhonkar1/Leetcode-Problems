class Solution {
    private void dfs(int heights[][], int i, int j, int height, boolean visited[][]){
        if(i<0 || j<0 || i>=heights.length || j>= heights[0].length || heights[i][j]<height) return;
        
        if(visited[i][j]) return;
        
        visited[i][j] = true;
        dfs(heights, i+1, j, heights[i][j], visited);
        dfs(heights, i, j+1, heights[i][j], visited);
        dfs(heights, i-1, j, heights[i][j], visited);
        dfs(heights, i, j-1, heights[i][j], visited);
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean pacificVisited[][] = new boolean[m][heights[0].length];
        boolean atlanticVisited[][] = new boolean[m][heights[0].length];
        
        for(int i=0; i<m; i++) dfs(heights, i, 0, heights[i][0], pacificVisited); 
        for(int i=0; i<n; i++) dfs(heights, 0, i, heights[0][i], pacificVisited);
        for(int i=0; i<m; i++) dfs(heights, i, n-1, heights[i][n-1], atlanticVisited);
        for(int i=0; i<n; i++) dfs(heights, m-1, i, heights[m-1][i] ,atlanticVisited);
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return ans;
    }
}