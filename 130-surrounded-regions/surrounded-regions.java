import java.util.*;

class Solution {

    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void bfs(char[][] board, int r, int c, boolean[][] visit) {

        int n = board.length;
        int m = board[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        visit[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair front = q.poll();
            int row = front.row;
            int col = front.col;

            for (int k = 0; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m &&
                    board[nr][nc] == 'O' && !visit[nr][nc]) {

                    visit[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visit[i][0])
                bfs(board, i, 0, visit);

            if (board[i][m - 1] == 'O' && !visit[i][m - 1])
                bfs(board, i, m - 1, visit);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !visit[0][j])
                bfs(board, 0, j, visit);

            if (board[n - 1][j] == 'O' && !visit[n - 1][j])
                bfs(board, n - 1, j, visit);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visit[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
