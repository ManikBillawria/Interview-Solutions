
class Solution {

    private void canReachOcean(int[][] heights, int i, int j, int m, int n, int prev, boolean[][] ocean) {
        if(i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if(heights[i][j] < prev) {
            return;
        }
        if(ocean[i][j]) {
            return;
        }

        ocean[i][j] = true;

        canReachOcean(heights, i+1, j, m, n, heights[i][j], ocean);
        canReachOcean(heights, i-1, j, m, n, heights[i][j], ocean);
        canReachOcean(heights, i, j+1, m, n, heights[i][j], ocean);
        canReachOcean(heights, i, j-1, m, n, heights[i][j], ocean);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        for(int i = 0; i < n; i++) {
            canReachOcean(heights, 0, i, m, n, Integer.MIN_VALUE, canReachPacific);
            canReachOcean(heights, m-1, i, m, n, Integer.MIN_VALUE, canReachAtlantic);
        }

        for(int i = 0; i < m; i++) {
            canReachOcean(heights, i, 0, m, n, Integer.MIN_VALUE, canReachPacific);
            canReachOcean(heights, i, n-1, m, n, Integer.MIN_VALUE, canReachAtlantic);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }
}