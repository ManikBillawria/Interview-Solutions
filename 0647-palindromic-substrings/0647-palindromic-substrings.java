class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(boolean[] row : dp) {
            Arrays.fill(row, true);
        }

        int count = s.length();

        for(int d = 1; d < n; d++) {
            int i = 0;
            int j = d;

            while(i < n && j < n) {
                if((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]) {
                    count++;
                } else {
                    dp[i][j] = false;
                }
                i++;
                j++;
            }
        }

        return count;
    }
}