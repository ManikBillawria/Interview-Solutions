class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        if(n == 0) {
            return new ArrayList<>();
        }
        
        List<List<String>> buckets = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for(String str : strs) {
            int[] countKey = new int[26];
            for(int i = 0; i < str.length(); i++) {
                countKey[str.charAt(i)-'a']++;
            }
            String hashKey = Arrays.toString(countKey);

            if(!hm.containsKey(hashKey)) {
                ArrayList<String> anagrams = new ArrayList<String>();
                anagrams.add(str);
                hm.put(hashKey, anagrams);
            }
            else {
                hm.get(hashKey).add(str);
            }
        }
        for(String key : hm.keySet()) {
            buckets.add(hm.get(key));
        }
        
        return buckets;
    }
}