class Solution {
    int []target = new int[] {0, 0};
    int squares = 0;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int []start = new int[] {0, 0};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start = new int[]{i, j};
                } else if (grid[i][j] == 2) {
                    target[0] = i;
                    target[1] = j;
                } else if (grid[i][j] == 0) {
                    squares++;
                }
                
            }
        }
        dfs(grid, new boolean[m][n], start[0], start[1], 0);
        return result;
    }
    
    int X[] = {1, -1, 0, 0};
    int Y[] = {0, 0, -1, 1};
    
    int result = 0;
    public int dfs(int[][] grid, boolean[][] vis, int row, int col, int cnt) {
        if (grid[row][col] == -1) {
            return 0;
        } else if (grid[row][col] == 2) {
            //System.out.println("Count = "+cnt);
            if (squares == cnt) {
                result++;
                return 1;
            } else {
                return 0;
            }
        }
        
        int res = 0;
        if (grid[row][col] == 0) cnt++;
        vis[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nrow = row + X[i];
            int ncol = col + Y[i];
            
            if (nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length && vis[nrow][ncol] != true) {
                res += dfs(grid, vis, nrow, ncol, cnt);
                
            }
        }
        vis[row][col] = false;
        return res;
    }
}