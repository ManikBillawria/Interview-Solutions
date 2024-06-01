class Solution {

    private int robUtil(int[] nums, int i, int n, int amount, int[][] memo) {
        if(i >= n) {
            return amount;
        }

        if(memo[i][amount] != -1) {
            return memo[i][amount];
        }

        int rob = robUtil(nums, i+2, n, amount+nums[i], memo);
        int notRob = robUtil(nums, i+1, n, amount, memo);

        return memo[i][amount] = Math.max(rob, notRob);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        int[][] memo = new int[n][totalSum+1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return robUtil(nums, 0, n, 0, memo);
    }
}