class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        int row = rows.get(rows.size()/2);
        Collections.sort(cols);
        int col = cols.get(cols.size()/2);
        
        return minDist(row, rows) + minDist(col, cols);
        
    }
    
    public int minDist(int x, List<Integer> X) {
        int dist = 0;
        
        for (int val : X) {
            dist += Math.abs(val - x);
        }
        return dist;
    }
}