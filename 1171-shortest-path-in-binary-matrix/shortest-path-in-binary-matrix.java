class Pair {
    int row;
    int col;
    int dist;
    
    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        int[] r = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] c = {0, 0, -1, 1, -1, 1, -1, 1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        grid[0][0] = 1; 

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;

            
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            for (int i = 0; i < 8; i++) {
                int newRow = row + r[i];
                int newCol = col + c[i];

                if (newRow >= 0 && newCol >= 0 && 
                    newRow < n && newCol < n && 
                    grid[newRow][newCol] == 0) {

                    q.add(new Pair(newRow, newCol, dist + 1));
                    grid[newRow][newCol] = 1; 
                }
            }
        }

        return -1;
    }
}