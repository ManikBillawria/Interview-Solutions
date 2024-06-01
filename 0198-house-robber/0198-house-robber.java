class Solution {

    private int robUtil(int[] nums, int i, int n, int[] memo) {
        if(i >= n) {
            return 0;
        }

        if(memo[i] != -1) {
            return memo[i];
        }

        int rob = nums[i] + robUtil(nums, i+2, n, memo);
        int notRob = robUtil(nums, i+1, n, memo);

        return memo[i] = Math.max(rob, notRob);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        return robUtil(nums, 0, n, memo);
    }
}