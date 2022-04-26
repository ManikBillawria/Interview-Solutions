class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        int totalSubsets = (1<<n); // 1<<n = 2^n
        
        for(int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                if((mask & (1<<i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            res.add(subset);
        }
        return res;
    }
}