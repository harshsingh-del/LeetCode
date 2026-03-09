class Solution {

    class DSU {
        int parent[];

        DSU(int n){
            parent = new int[n + 1];
            for(int i = 1; i <= n; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return false; // cycle detected

            parent[pb] = pa;
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!dsu.union(u, v)){
                return edge;
            }
        }

        return new int[]{};
    }
}