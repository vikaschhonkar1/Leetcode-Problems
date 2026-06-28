class Solution {

    private boolean dfs(int r, int c, int idx, char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Rule out out-of-bound indexes
        if (r < 0 || r >= m || c < 0 || c >= n) return false;

        // If char dont match word's char
        if (board[r][c] != word.charAt(idx)) return false;

        // now if the index is last one and from above it is sure that the elements match 
        if (idx == word.length() - 1) return true;

        // Store current value in temp and mark it some another value so that we do not 
        // count it multiple times in dfs
        char temp = board[r][c];
        board[r][c] = '*';

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int d = 0; d < 4; d++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            if (dfs (nr, nc, idx + 1, board, word)) {
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

        // Traverse each element and find whether we can start dfs from there or not 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // DFS state will look like
                    // current_i, current_j, current_idx_of_word, board, word)
                    if (dfs(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}