class Solution {
    class dsu {
        int parent[], rank[];
        dsu(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x){
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b){
            int pa = find(a), pb = find(b);
            if(pa == pb) return;

            if(rank[pa] < rank[pb]) parent[pa] = pb;
            else if(rank[pb] < rank[pa]) parent[pb] = pa;
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int cost = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{cost, i, j});
            }
        }
        Collections.sort(edges, (a,b) -> a[0] - b[0]);
        dsu uf = new dsu(n);
        int totalCost = 0;
        int edgesUsed = 0;
        for(int[] e : edges){
            int cost = e[0];
            int u = e[1];
            int v = e[2];

            if(uf.find(u) != uf.find(v)){
                uf.union(u,v);
                totalCost += cost;
                edgesUsed++;

                if(edgesUsed == n-1) break;
            }
        }
        return totalCost;
    }
}