import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<List<double[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            
            graph.get(u).add(new double[]{v, prob});
            graph.get(v).add(new double[]{u, prob});
        }
        
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b[1], a[1])
        );
        
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        
        pq.offer(new double[]{start_node, 1.0});
        
        while (!pq.isEmpty()) {
            double[] current = pq.poll();
            int node = (int) current[0];
            double prob = current[1];
            
            if (node == end_node) {
                return prob;
            }
            
            if (prob < maxProb[node]) continue;
            
            for (double[] neighbor : graph.get(node)) {
                int next = (int) neighbor[0];
                double edgeProb = neighbor[1];
                
                double newProb = prob * edgeProb;
                
                if (newProb > maxProb[next]) {
                    maxProb[next] = newProb;
                    pq.offer(new double[]{next, newProb});
                }
            }
        }
        
        return 0.0;
    }
}