class Solution {

    int getMaxApAt(int[] nums, int diff, int idx, int n, Map<Integer, Integer>[] memo) {
        if(idx <= 0) {
            return 0;
        }

        if(memo[idx].containsKey(diff)) {
            return memo[idx].get(diff);
        }

        int ans = 0;

        for(int k = idx-1; k >= 0; k--) {
            if(nums[idx]-nums[k] == diff) {
                ans = Math.max(ans, 1 + getMaxApAt(nums, diff, k, n, memo));
            }
        }
        memo[idx].put(diff, ans);
        return memo[idx].get(diff);
    }

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;

        int res = 2; //because constraint 2 <= nums.length <= 1000

        Map<Integer, Integer>[] memo = new HashMap[n+1];

        for(int i = 0; i < n; i++) {
            memo[i] = new HashMap<>();
        }

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                //get max AP at with i, j as last two elements
                res = Math.max(res, 2+getMaxApAt(nums, nums[j]-nums[i], i, n, memo));
            }
        }

        return res;
    }
}