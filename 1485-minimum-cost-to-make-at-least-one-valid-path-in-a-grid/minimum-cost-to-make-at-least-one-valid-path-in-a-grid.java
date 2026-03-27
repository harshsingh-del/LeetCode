class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] cost = new int[m][n];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.offer(new int[]{0, 0, 0});
        cost[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int r = curr[1];
            int c = curr[2];
            if (r == m - 1 && c == n - 1) {
                return currCost;
            }
            if (currCost > cost[r][c]) continue;

            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newCost = currCost + (grid[r][c] == i + 1 ? 0 : 1);
                    if (newCost < cost[nr][nc]) {
                        cost[nr][nc] = newCost;
                        pq.offer(new int[]{newCost, nr, nc});
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}