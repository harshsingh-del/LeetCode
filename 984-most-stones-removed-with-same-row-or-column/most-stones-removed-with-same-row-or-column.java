class Solution {
    class dsu{
        int parent[];
        int rank[];
        dsu(int n){
            parent= new int[n];
            rank= new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        void union(int a, int b){
            int pa=find(a);
            int pb=find(b);
            if(pa==pb) return ;
            if(rank[pa]<rank[pb]){
                parent[pa]=pb;
            }else if(rank[pb]<rank[pa]){
                parent[pb]=pa;
            }else{
                parent[pb]=pa;
                rank[pa]++;      
          }
        }
    }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        dsu dsu= new dsu(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    dsu.union(i,j);
                }
            }
        }
    Set<Integer> uniqueParents = new HashSet<>();
    for(int i = 0; i < n; i++){
        uniqueParents.add(dsu.find(i));
    }

    return n - uniqueParents.size();

        
    }
}