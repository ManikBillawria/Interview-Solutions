class Solution {

    private int robUtil(int[] nums, int i, int n, int robbedFirst, int[][] memo) {
        if(i >= n) {
            return 0;
        }

        if(memo[i][robbedFirst] != -1) {
            return memo[i][robbedFirst];
        }

        int rob = 0;
        if(i == 0) {
            rob = nums[i] + robUtil(nums, i+2, n, 1, memo);
        } else if(i == n-1) {
            if(!(robbedFirst == 1)) {
                rob = nums[i] + robUtil(nums, i+2, n, robbedFirst, memo);
            }
        } else {
            rob = nums[i] + robUtil(nums, i+2, n, robbedFirst, memo);
        }

        int notRob = robUtil(nums, i+1, n, robbedFirst, memo);

        return memo[i][robbedFirst] = Math.max(rob, notRob);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        int[][] memo = new int[n][2];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return robUtil(nums, 0, n, 0, memo);
    }
}