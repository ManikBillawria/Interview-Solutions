class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(n == 1) {
            return (target <= nums[0]) ? 0 : 1;
        }
        int left = 0;
        int right = n-1;
        
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return right+1;
    }
}