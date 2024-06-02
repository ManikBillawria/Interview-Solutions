class Solution {

    private long getCoins(int[] coins, int n, int amount, long[] memo) {
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }
        if(amount == 0) {
            return 0;
        }
        if(memo[amount] != -1) {
            return memo[amount];
        }

        long ans = Integer.MAX_VALUE;
        for(int coin : coins) {
            ans = Math.min(ans, 1+getCoins(coins, n, amount-coin, memo));
        }

        return memo[amount] = ans;
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        long[] memo = new long[amount+1];
        Arrays.fill(memo, -1);

        long totalCoins = getCoins(coins, n, amount, memo);

        return (totalCoins < Integer.MAX_VALUE) ? (int)totalCoins : -1;
    }
}