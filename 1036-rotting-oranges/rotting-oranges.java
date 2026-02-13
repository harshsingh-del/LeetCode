class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public boolean  isValid(int x,int y, int m, int n){
        if(x>=0 && y>=0 && x<m && y<n) return true;
        return false;

        
    }
    int rowdirection[]={-1,1,0,0};
    int coldirection []={0,0,1,-1};

    public int orangesRotting(int[][] grid) {
      Queue <Pair> q= new LinkedList<>();
        int m= grid.length;
        int n=grid[0].length;
        boolean [][] visit= new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2 && !visit[i][j]){
                     q.add(new Pair(i,j));
                    visit[i][j]=true;
              }
            }
        }
        int min=0;
        while(!q.isEmpty()){
            boolean flag=false;
            int size=q.size();
            while(size!=0){
                size--;
                Pair curr=q.poll();
                int currow=curr.row;
                int curcol=curr.col;
                for(int i=0;i<4;i++){
                    int newrow=currow+rowdirection[i];
                    int newcol=curcol+coldirection[i];
                    if(isValid(newrow,newcol, m,n) && grid[newrow][ newcol]==1  && visit[newrow][newcol]==false){
                        flag=true;
                        q.add(new Pair(newrow,newcol));
                        visit[newrow][newcol]=true;
                        grid[newrow][newcol]=2;
                    }
                }
            }
            if(flag == true) min++;

        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return min;
        
    }
}