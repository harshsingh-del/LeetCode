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
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a,b) -> a[2] - b[2]);
        int q = queries.length;
        int[][] qWithIndex = new int[q][4];
        for(int i=0;i<q;i++){
            qWithIndex[i][0] = queries[i][0];
            qWithIndex[i][1] = queries[i][1];
            qWithIndex[i][2] = queries[i][2];
            qWithIndex[i][3] = i;
        }
        Arrays.sort(qWithIndex,(a,b)->a[2]-b[2]);
        boolean[] ans = new boolean[q];
        dsu d = new dsu(n);
        int j = 0;
        for(int i=0;i<q;i++){
            int u = qWithIndex[i][0];
            int v = qWithIndex[i][1];
            int limit = qWithIndex[i][2];
            int idx = qWithIndex[i][3];
            while(j < edgeList.length && edgeList[j][2] < limit){
                d.union(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            ans[idx] = (d.find(u) == d.find(v));
        }
        return ans;
    }
}