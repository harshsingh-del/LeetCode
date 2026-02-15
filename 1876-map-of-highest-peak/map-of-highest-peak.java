import java.util.*;

class Solution {

    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[] dRow = {1, -1, 0, 0};
    int[] dCol = {0, 0, 1, -1};

    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                    height[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){

            Pair curr = q.poll();

            for(int k = 0; k < 4; k++){

                int newRow = curr.row + dRow[k];
                int newCol = curr.col + dCol[k];

                if(newRow >= 0 && newRow < m &&
                   newCol >= 0 && newCol < n &&
                   !vis[newRow][newCol]){

                    vis[newRow][newCol] = true;
                    height[newRow][newCol] = height[curr.row][curr.col] + 1;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }

        return height;
    }
}
