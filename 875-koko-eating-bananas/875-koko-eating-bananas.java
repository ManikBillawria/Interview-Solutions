class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 0, high = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            high = Math.max(high, piles[i]);
        }
        int speed = high;
        while(low <= high) {
            int mid = (low+high)/2;
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += (int)Math.ceil((piles[i]*1.0)/mid);
            }
            System.out.println();
            System.out.println(mid+" "+sum);
            if(sum <= h) {
                speed = Math.min(speed, mid);
                high = mid-1;
            }
            else if(sum > h) {
                low = mid+1;
            }
        }
        return speed;
    }
}