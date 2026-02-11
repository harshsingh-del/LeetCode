class Pair {
    int row, col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    int[] dRow = {-1, 1, 0, 0};
    int[] dCol = {0, 0, -1, 1};
    
    public void bfs(int i, int j, int[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        vis[i][j] = true;
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            
            for(int k = 0; k < 4; k++) {
                int newRow = curr.row + dRow[k];
                int newCol = curr.col + dCol[k];
                
                if(newRow >= 0 && newRow < n &&
                   newCol >= 0 && newCol < m &&
                   !vis[newRow][newCol] &&
                   grid[newRow][newCol] == 1) {
                    
                    vis[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }
    }
    
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            if(grid[i][0] == 1 && !vis[i][0])
                bfs(i, 0, grid, vis);
            
            if(grid[i][m - 1] == 1 && !vis[i][m - 1])
                bfs(i, m - 1, grid, vis);
        }
        
        for(int j = 0; j < m; j++) {
            if(grid[0][j] == 1 && !vis[0][j])
                bfs(0, j, grid, vis);
            
            if(grid[n - 1][j] == 1 && !vis[n - 1][j])
                bfs(n - 1, j, grid, vis);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
