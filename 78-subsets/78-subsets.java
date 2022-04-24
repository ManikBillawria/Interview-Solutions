class Solution {
    
    void subsetsUtil(int[] nums, int i, int n, int setSize, List<Integer> set, List<List<Integer>> res) {
        if(i == n) {
            for(int k = 0; k < setSize; k++) {
                System.out.print(set.get(k)+" ");
            }
            System.out.println();
            res.add(new ArrayList<>(set));
            return;
        }
        subsetsUtil(nums, i+1, n, setSize, set, res);
        
        set.add(setSize, nums[i]);
        subsetsUtil(nums, i+1, n, setSize+1, set, res);
        
        set.remove(set.size()-1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        int n = nums.length;
        
        subsetsUtil(nums, 0, n, 0, set, res);
        return res;
    }
}