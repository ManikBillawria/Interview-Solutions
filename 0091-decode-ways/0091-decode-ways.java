class Solution {

    private int getWays(String s, int i, int n, int[] memo) {
        if(i > n) {
            return 0;
        }

        if(i == n) {
            return 1;
        }

        if(s.charAt(i) == '0') {
            return 0;
        }

        if(memo[i] != -1) {
            return memo[i];
        }

        int ways = 0;

        int groupOne = getWays(s, i+1, n, memo);
        ways += groupOne;

        if(i+1 < n && s.substring(i, i+2).compareTo("26") <= 0) {
            int groupTwo = getWays(s, i+2, n, memo);
            ways += groupTwo;
        }
        
        return memo[i] = ways;
    }

    public int numDecodings(String s) {
        int n = s.length();
        
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return getWays(s, 0, n, memo);
    }
}

/**
1106

 */