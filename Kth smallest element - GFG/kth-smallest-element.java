//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int countSmaller(int[] arr, int l, int r, int mid) {
        int count = 0;
        for(int i = l; i <= r; i++) {
            if(arr[i] <= mid) {
                count++;
            }
        }
        
        return count;
    }
    
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = l; i <= r; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        int mid;
        
        while(min <= max) {
            mid = (min+max)/2;
            
            int count = countSmaller(arr, l, r, mid);
            if(count < k) {
                min = mid+1;
            }
            else {
                if(countSmaller(arr, l, r, mid-1) >= k) {
                    max = mid-1;
                }
                else {
                    return mid;
                }
            }
        }
        
        return -1;
    } 
}
