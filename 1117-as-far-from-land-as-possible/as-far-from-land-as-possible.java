import java.util.*;

class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }

    int rowDirection[] ={1,-1,0,0};
    int colDirection[] ={0,0,1,-1};

    public int maxDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    vis[i][j] = true;
                    q.add(new Pair(i,j));
                    ans[i][j] = 0;
                }
            }
        }

        if(q.isEmpty() || q.size() == m*n) return -1;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currPairRow = curr.row;
            int currPairCol = curr.col;

            for(int i=0;i<4;i++){
                int newRow = currPairRow + rowDirection[i];
                int newCol = currPairCol + colDirection[i];

                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
                    if(!vis[newRow][newCol]){
                        q.add(new Pair(newRow,newCol));
                        vis[newRow][newCol] = true;
                        ans[newRow][newCol] = ans[currPairRow][currPairCol] + 1;
                    }
                }
            }
        }

        int mx = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    mx = Math.max(mx, ans[i][j]);
                }
            }
        }

        return mx;
    }
}
