// Pair Class
class Pair {
    int node;
    double probability;

    // Constructor
    Pair(int node, double probability) {
        this.node = node;
        this.probability = probability;
    }
}


class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        // Creatiing adjacency list from edge list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) { 
            adj.add(new ArrayList<Pair>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        // Max Heap
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> {
            return Double.compare(b.probability, a.probability);
        });

        double maxProb[] = new double[n];
        maxProb[start] = 1.0;

        pq.add(new Pair(start, 1));

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            double probability = pq.peek().probability;
            pq.remove();

            if(node == end) return probability;

            for(Pair nbr : adj.get(node)){
                if(probability * nbr.probability > maxProb[nbr.node]){
                    maxProb[nbr.node] = probability * nbr.probability;
                    pq.add(new Pair(nbr.node, probability * nbr.probability));
                }
            }
        }

        return 0;
    }
}