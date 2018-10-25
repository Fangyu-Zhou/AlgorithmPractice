public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] res = {n*n};
        dfs(board, res, new boolean[n * n], n, 1, 0);
        System.out.println(res[0]);
        return res[0];
    }

    private void dfs(int[][] board, int[] res, boolean[] visited, int n, int pos, int step) {

        if (pos >= n * n) {
            res[0] = Math.min(res[0], step);
            return;
        }
        if (visited[pos]) {
            return;
        }
        visited[pos] = true;

        for (int i = 1; i <= 6; i ++) {
            int newPos = pos + i;
            if (newPos >= n * n) {
                res[0] = Math.min(res[0], step + 1);
            }
            int quot = (newPos-1) / n;
            int rem = (newPos-1) % n;
            int row = n - 1 - quot;
            int col = row % 2 != n % 2 ? rem : n - 1 - rem;
            if (row >= n || col >= n || row < 0 || col < 0) continue;
            if (board[row][col] != -1) {
                dfs(board, res, visited, n, board[row][col], step + 1);
            } else {
                dfs(board, res, visited, n, newPos, step + 1);
            }
        }

    }
}
