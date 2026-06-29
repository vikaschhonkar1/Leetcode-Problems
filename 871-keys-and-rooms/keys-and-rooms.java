class Solution {

    private void dfs(int curr, boolean[] vis, List<List<Integer>> adj) {
        vis[curr] = true;

        List<Integer> currList = adj.get(curr);
        for (int i: currList) {
            if (!vis[i]) {
                dfs(i, vis, adj);
            }
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            List<Integer> currentList = rooms.get(i);
            for (int val: currentList) {
                if (i != val) adj.get(i).add(val);
            }
        }

        boolean vis[] = new boolean[n];

        // state of dfs curr, vis, adj
        dfs(0, vis, adj);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) return false;
        }

        return true;
    }
}