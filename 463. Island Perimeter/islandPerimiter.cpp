	int islandPerimeter(vector<vector<int>>& grid) {
        vector<vector<int>> visited(grid.size(), vector<int>(grid[0].size(), 0));
       
        int peri = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 1) {
                    if (visited[i][j] != 1) {
                        dfs(grid, visited, i, j, peri);
                    }
                }
            }
        }
        return peri;
    }
    
    bool isValid(vector<vector<int>>& grid, int row, int col) {
        if (row >= grid.size() || row < 0 || col >= grid[0].size() || col < 0) {
            return false;
        }
        return true;
    }
    
    void dfs(vector<vector<int>>& grid, vector<vector<int>>& visited, int row, int col, int &peri) {
        visited[row][col] = 1;
        if (grid[row][col] == 0) {
            peri++;
            return;
        }
        int cols[] = {1, -1, 0, 0};
        int rows[] = {0, 0, 1, -1};
        
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = row + rows[i];
            nc = col + cols[i];
            
            if (isValid(visited, nr, nc)) {
                if (visited[nr][nc] == 0) {
                    dfs(grid, visited, nr, nc, peri);
                } else {
				    // If cell already visited but is an endpoint
                    if (grid[nr][nc] == 0) {
                        peri++;
                    }
                }
            } else {
                peri++;
            }
        }
    }
