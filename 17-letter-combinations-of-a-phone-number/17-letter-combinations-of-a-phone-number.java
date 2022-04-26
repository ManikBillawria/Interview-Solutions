class Solution {
    
    void combos(String digits, String combo, int i, int n, List<String> res, String[] mapping) {
        if(i == n) {
            if(combo == "")
                return;
            res.add(combo);
            return;
        }
        int digit = Character.getNumericValue(digits.charAt(i));
        // System.out.println(digit);
        String options = mapping[digit];
        
        for(int k = 0; k < options.length(); k++) {
            combos(digits, combo+options.charAt(k), i+1, n, res, mapping);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        int n = digits.length();
        
        List<String> res = new ArrayList<String>();
        
        combos(digits, "", 0, n, res, mapping);
        
        return res;
    }
}