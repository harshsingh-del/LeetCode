class Solution {
    public void bfs (int i, int[][] isConnected, boolean [] visit){
         int n=isConnected.length;
        visit[i]=true;
        Queue <Integer> q=new LinkedList<>();
        q.add(i);
       while(!q.isEmpty()){
        int front=q.remove();
        for(int j=0;j<n;j++){
            if(isConnected[front][j]==1 && !visit[j]){
                q.add(j);
                visit[j]=true;
            }
        }
       }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        boolean [] vist= new boolean[n];
        for(int i=0;i< n;i++){
            if(!vist[i]){
                bfs(i,isConnected,vist);
                count++;
            }
        }
        return count;
        
    }
}