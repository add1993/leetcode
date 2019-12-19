class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean visited[][] = new boolean[board.length][board[0].length]; 
                    if (dfs(board, visited, word, i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int idx) {
        if (idx >= word.length()) return true;
        if (visited[row][col] == true) return false;
        
        visited[row][col] = true;
        int X[] = {1, -1, 0, 0};
        int Y[] = {0, 0, 1, -1};
        
        for (int i = 0; i < 4; i++) {
            int nrow = row + X[i];
            int ncol = col + Y[i];
            
            if (nrow >= 0 && ncol >= 0 && nrow < board.length && ncol < board[0].length && visited[nrow][ncol] == false && board[nrow][ncol] == word.charAt(idx)) {
                if (dfs(board, visited, word, nrow, ncol, idx+1) == true) {
                    return true;
                }
                visited[nrow][ncol] = false;
            }
           
        }
        
        return false;
    }
}