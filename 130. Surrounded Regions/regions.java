class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) return;
        int cols = board[0].length;
        boolean visited[][] = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (visited[i][0] == false && board[i][0] == 'O') {
                dfs(board, visited, i, 0);
            }
            if (visited[i][cols-1] == false && board[i][cols-1] == 'O') {
                dfs(board, visited, i, cols-1);
            }
        }
        
        for (int i = 0; i < cols; i++) {
            if (visited[0][i] == false && board[0][i] == 'O') {
                dfs(board, visited, 0, i);
            }
            if (visited[rows-1][i] == false && board[rows-1][i] == 'O') {
                dfs(board, visited, rows-1, i);
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    void dfs(char[][] board, boolean[][] visited, int r, int c) {
        if (visited[r][c] == true) return;
        visited[r][c] = true;
        int X[] = {0,0,1,-1};
        int Y[] = {1, -1, 0, 0};
        
        for (int i = 0; i < 4; i++) {
            int nr = r + X[i];
            int nc = c + Y[i];
            
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length) {
                if (board[nr][nc] == 'O' && visited[nr][nc] == false) {
                    dfs(board, visited, nr, nc);
                }
            }
        }
    }
}