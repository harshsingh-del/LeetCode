class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        q.offer(new int[]{entrance[0], entrance[1]});
        vis[entrance[0]][entrance[1]] = true;
        int steps = 0;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!q.isEmpty()) {
            int size = q.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                        && maze[nr][nc] == '.' && !vis[nr][nc]) {
                        if (nr == 0 || nr == m-1 || nc == 0 || nc == n-1) {
                            return steps;
                        }

                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}