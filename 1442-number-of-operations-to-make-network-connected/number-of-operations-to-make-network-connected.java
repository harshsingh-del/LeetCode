class Solution {
    class dsu {
        int parent[], rank[];
        dsu(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        int find(int x){
            if(parent[x]!=x) parent[x]=find(parent[x]);
            return parent[x];
        }
        void union(int a, int b){
            int pa=find(a), pb=find(b);
            if(pa==pb) return;
            if(rank[pa]<rank[pb]) parent[pa]=pb;
            else if(rank[pb]<rank[pa]) parent[pb]=pa;
            else { parent[pb]=pa; rank[pa]++; }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        dsu d = new dsu(n);
        for(int[] conn : connections){
            d.union(conn[0], conn[1]);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(d.find(i) == i) count++;
        }
        return count - 1;
    }
}