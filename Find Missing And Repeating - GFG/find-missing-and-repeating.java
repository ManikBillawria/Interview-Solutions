//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xor = 0;
        for(int i = 0; i < n; i++) {
            xor ^= arr[i];
        }
        
        for(int i = 1; i <= n; i++) {
            xor ^= i;
        }
        
        int rsbm = xor & -xor;
        
        int bucket1 = 0;
        int bucket2 = 0;
        
        for(int i = 0; i < n; i++) {
            if((arr[i] & rsbm) == 0) {
                bucket2 ^= arr[i];
            }
            else {
                bucket1 ^= arr[i];
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if((i & rsbm) == 0) {
                bucket2 ^= i;
            }
            else {
                bucket1 ^= i;
            }
        }
        
        int missing = -1, duplicate = -1;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == bucket1) {
                duplicate = bucket1;
                missing = bucket2;
                break;
            }
            else if(arr[i] == bucket2) {
                duplicate = bucket2;
                missing = bucket1;
                break;
            }
        }
        
        return new int[]{duplicate, missing};
    }
}