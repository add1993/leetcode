class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if (matrix.size() < 0 || matrix[0].size() < 0) return;
        vector<vector<bool>> visited(matrix.size(), vector<bool>(matrix[0].size(), false));
        int x[] = {0, 1, -1, 0};
        int y[] = {1, 0, 0, -1};
        
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                if (visited[i][j] == false && matrix[i][j] == 0) {
                    visited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        dfs(matrix, visited, i+x[k], j+y[k], x[k], y[k]);
                    }
                }
            }
        }
    }
    
    void dfs(vector<vector<int>>& matrix, vector<vector<bool>> &visited, int row, int col, int xx, int yy) {
        if (row >= 0 && row < matrix.size() && col >= 0 && col < matrix[0].size() && (visited[row][col] == false || matrix[row][col] == 0)) {
            if (matrix[row][col] != 0)
                visited[row][col] = true;
            matrix[row][col] = 0;
            dfs(matrix, visited, row+xx, col+yy, xx, yy);
        }
    }
};