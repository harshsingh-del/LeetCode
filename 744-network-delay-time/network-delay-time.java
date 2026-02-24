class Solution {
    class Pair {
        int node;
        int dist;
        
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }  
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new Pair(v, w));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[k] = 0;
        pq.add(new Pair(k, 0));
        
        while (!pq.isEmpty()) {
            
            Pair current = pq.poll();
            int node = current.node;
            int d = current.dist;
            
            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int weight = neighbor.dist;
                
                if (d + weight < dist[adjNode]) {
                    dist[adjNode] = d + weight;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        
        int maxTime = 0;
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        
        return maxTime;
    }
}