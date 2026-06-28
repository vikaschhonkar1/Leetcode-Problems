class Solution {
    private boolean dfs(int r, int c, int idx, char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }

        if (board[r][c] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }

        char temp = board[r][c];
        board[r][c] = '*';

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            if (dfs(nr, nc, idx + 1, board, word)) {
                board[r][c] = temp;
                return true;
            }
        }

        board[r][c] = temp;
        return false;
    }


    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}