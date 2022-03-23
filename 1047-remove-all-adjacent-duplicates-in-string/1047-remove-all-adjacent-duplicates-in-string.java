class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        if(n == 1)
            return s;
        
        Stack<Character> st = new Stack<Character>();
        st.push(s.charAt(0));
        for(int i = 1; i < n; i++) {
            if(!st.isEmpty() && s.charAt(i) == st.peek()) {
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        String res = "";
        while(!st.isEmpty()) {
            res = st.pop()+res;
        }
        return res;
    }
}