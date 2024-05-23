class Solution {
    public String largestPalindromic(String num) {
        int n = num.length();
        int[] freq = new int[10];

        
        for(int i = 0; i < n; i++) {
            freq[num.charAt(i)-'0']++;
        }

        String firstHalf = "";
        boolean leadingChar = true;

        for(int i = 9; i >= 0; i--) {
            if(i == 0 && leadingChar) {
                break;
            }
            if(freq[i] > 1) {
                int countUsed = freq[i]/2;
                freq[i] = freq[i] - 2*countUsed;
                
                while(countUsed-- > 0) {
                    firstHalf += String.valueOf(i);
                }
                
                leadingChar = false;
            }
        }

        String middlePart = "";

        for(int i = 9; i >= 0; i--) {
            if(freq[i] >= 1) {
                middlePart += String.valueOf(i);
                freq[i]--;
                break;
            }
        }

        String lastPart = "";

        for(int i = firstHalf.length()-1; i >= 0; i--) {
            lastPart += firstHalf.charAt(i);
        }

        return firstHalf+middlePart+lastPart;
    }
}