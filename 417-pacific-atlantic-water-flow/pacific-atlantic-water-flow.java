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

    int[] rowDir = {1, -1, 0, 0};
    int[] colDir = {0, 0, 1, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<Pair> pacQueue = new LinkedList<>();
        Queue<Pair> atlQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacQueue.add(new Pair(i, 0));
            atlQueue.add(new Pair(i, n - 1));
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pacQueue.add(new Pair(0, j));
            atlQueue.add(new Pair(m - 1, j));
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pacQueue, pacific);
        bfs(heights, atlQueue, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<Pair> queue, boolean[][] visited) {

        int m = heights.length;
        int n = heights[0].length;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            for (int i = 0; i < 4; i++) {

                int newRow = curr.row + rowDir[i];
                int newCol = curr.col + colDir[i];

                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol] &&
                    heights[newRow][newCol] >= heights[curr.row][curr.col]) {

                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }
}
