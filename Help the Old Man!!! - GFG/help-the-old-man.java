// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int n = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.shiftPile(N, n);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int count;
    
    static void shiftPileUtil(int N, int n, int src, int helper, int dest, List<Integer>res) {
        if(N == 0) {
            return;
        }
        
        shiftPileUtil(N-1, n, src, dest, helper, res);
        count++;
        if(count == n) {
            res.add(src);
            res.add(dest);
        }
        shiftPileUtil(N-1, n, helper, src, dest, res);
    }
    
    static List<Integer> shiftPile(int N, int n){
        // code here
        List<Integer> res = new ArrayList<Integer>();
        count = 0;
        
        shiftPileUtil(N, n, 1, 2, 3, res);
        
        return res;
    }
}