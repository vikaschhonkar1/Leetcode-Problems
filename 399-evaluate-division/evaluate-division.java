class Solution {
    static class Pair {
        String v; 
        double w;

        Pair(String v, double w) {
            this.v = v;
            this.w = w;
        }
    }

    private double dfs(String u, String v, HashSet<String> visited, HashMap<String, ArrayList<Pair>> adj) {
        visited.add(u);

        if (u.equals(v)) {
            return 1.00;
        }

        for (Pair element: adj.get(u)) {
            if (!visited.contains(element.v)) {
                double currW = dfs(element.v, v, visited, adj);
                if (currW > 0) {
                    return currW * element.w;
                }
            }
        }

        return -1.00;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();

        HashMap<String, ArrayList<Pair>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> currElement = equations.get(i);
            String u = currElement.get(0);
            String v = currElement.get(1);
            double w = values[i];

            if(!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }

            if(!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, 1/w));
        }


        int m = queries.size();
            double ans[] = new double[m];
            
            for(int i = 0; i < m; i++) {
                List<String> currentQuery = queries.get(i);

                String u = currentQuery.get(0);
                String v = currentQuery.get(1);
                
                if (!adj.containsKey(u) || !adj.containsKey(v)) {
                    ans[i] = -1.00;
                    continue;
                }

                // dfs state will look like (u, v, visited, adj)
                // visited will be hashset and will be new everytime
                HashSet<String> visited = new HashSet<>();
                double w = dfs(u, v, visited, adj);

                ans[i] = w;
            }

            return ans;
    }
}