class Solution {

    private void markIsland(char[][] grid, int i, int j, int m, int n, boolean[][] vis) {
        if(i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if(grid[i][j] == '0') {
            return;
        }
        if(vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        markIsland(grid, i+1, j, m, n, vis);
        markIsland(grid, i-1, j, m, n, vis);
        markIsland(grid, i, j+1, m, n, vis);
        markIsland(grid, i, j-1, m, n, vis);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        int islands = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    islands++;
                    markIsland(grid, i, j, m, n, vis);
                }
            }
        }

        return islands;
    }
}