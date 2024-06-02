class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(boolean[] row : dp) {
            Arrays.fill(row, true);
        }

        String lps = s.substring(0, 1);

        for(int d = 1; d < n; d++) {
            int i = 0;
            int j = d;

            while(i < n && j < n) {
                if((s.charAt(i) == s.charAt(j)) && dp[i+1][j-1]) {
                    if(j-i+1 > lps.length()) {
                        lps = s.substring(i, j+1);
                    }
                } else {
                    dp[i][j] = false;
                }
                i++;
                j++;
            }
        }

        return lps;
    }
}