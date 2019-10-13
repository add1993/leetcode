class Solution {
public:
    vector<int> shape;
    int numDistinctIslands(vector<vector<int>>& grid) {
        vector<vector<int>> visited(grid.size(), vector<int>(grid[0].size(), 0));
        set<vector<int>> shapes;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 1) {
                    if (visited[i][j] != 1) {
                        shape.clear();
                        dfs(grid, visited, i, j, 0);
                        if (shape.size() > 0) {
                            shapes.insert(shape);
                        }
                    }
                }
            }
        }
        return shapes.size();
    }
    
    bool isValid(vector<vector<int>>& grid, int row, int col) {
        if (row >= grid.size() || row < 0 || col >= grid[0].size() || col < 0) {
            return false;
        }
        return true;
    }
    
    void dfs(vector<vector<int>>& grid, vector<vector<int>>& visited, int row, int col, int dir) {
        visited[row][col] = 1;
        if (grid[row][col] == 0) {
            return;
        }
        int cols[] = {1, -1, 0, 0};
        int rows[] = {0, 0, 1, -1};
        shape.push_back(dir);
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = row + rows[i];
            nc = col + cols[i];
            
            if (isValid(visited, nr, nc)) {
                if (visited[nr][nc] == 0) {
                    dfs(grid, visited, nr, nc, i + 1);
                }
            }
        }
        shape.push_back(0);
    }
};