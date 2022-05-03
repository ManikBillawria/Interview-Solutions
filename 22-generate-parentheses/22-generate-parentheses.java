class Solution {
    
    void gP(int n, int open, int closed, String combo, List<String> allCombos) {
        if(open+closed == 2*n) {
            allCombos.add(combo);
            return;
        }
        
        if(open == closed) {
            gP(n, open+1, closed, combo+"(", allCombos);
        }
        else if(open > closed) {
            if(open == n) {
                gP(n, open, closed+1, combo+")", allCombos);
            }
            else {
                gP(n, open+1, closed, combo+"(", allCombos);
                gP(n, open, closed+1, combo+")", allCombos);
            }
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> allCombos = new ArrayList<String>();
        
        gP(n, 0, 0, "", allCombos);
        
        return allCombos;
    }
}