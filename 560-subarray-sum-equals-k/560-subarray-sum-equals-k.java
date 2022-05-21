class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        int ps = 0;
        int res = 0;
        hs.put(0, 1);
        for(int i = 0; i < n; i++) {
            ps += nums[i];
            if(hs.containsKey(ps-k)) {
                res += hs.get(ps-k);
            }
            if(hs.containsKey(ps)) {
                hs.put(ps, hs.get(ps)+1);
            }
            else {
                hs.put(ps, 1);
            }
        }
        return res;
    }
}
