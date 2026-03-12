class Solution {
    class DSU{
        int[] parent,size;
        DSU(int n){
            parent = new int[n+1];
            size = new int[n+1];
            for(int i=1;i<=n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int u){
            if(parent[u] == u) return u;
            return parent[u] = find(parent[u]);
        }
        public boolean union(int u,int v){
            u = find(u);
            v = find(v);
            if(u==v) return false;
            if(size[u] > size[v]){
                parent[v] = u;
                size[u] += size[v];  
            }
            else{
                parent[u] = v;
                size[v] += size[u]; 
            }
            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int reqEdge = 0;
        for(int[] arr:edges){
            if(arr[0] == 3){
                if(alice.union(arr[1],arr[2]) | bob.union(arr[1],arr[2])) reqEdge++;
            }
        }
        for(int[] e : edges){
            if(e[0] == 1 && alice.union(e[1],e[2])) reqEdge++;
            if(e[0] == 2 && bob.union(e[1],e[2])) reqEdge++;
        }
        
        if(alice.size[alice.find(1)] != n || bob.size[bob.find(1)] != n) return -1;
        return edges.length - reqEdge;
    }
}