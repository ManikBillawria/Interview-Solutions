class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {

        Map<Integer, Integer> freq1 = new HashMap<>();
        int max1 = Integer.MIN_VALUE;

        for(int num : nums1) {
            max1 = Math.max(max1, num);

            int count = freq1.getOrDefault(num, 0);
            freq1.put(num, count+1);
        }

        Map<Integer, Integer> freq2 = new HashMap<>();
        for(int num : nums2) {
            int count = freq2.getOrDefault(num, 0);
            freq2.put(num, count+1);
        }

        long pairs = 0;

        for(Map.Entry<Integer, Integer> entry2 : freq2.entrySet()) {
            int divisor = entry2.getKey()*k;
            int diff = divisor;

            while(divisor <= max1) {
                if(freq1.containsKey(divisor)) {
                    pairs += ((long) freq1.get(divisor)*(long)entry2.getValue());
                }
                divisor += diff;
            }
        }

        return pairs;
    }
}