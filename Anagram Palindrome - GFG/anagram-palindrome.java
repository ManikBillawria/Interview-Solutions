//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends


class Sol
{
    int isPossible (String S)
    {
        // your code here
        int n = S.length();
        Set<Character> characters = new HashSet<>();
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(characters.contains(S.charAt(i))) {
                count--;
                characters.remove(S.charAt(i));
            }
            else {
                characters.add(S.charAt(i));
                count++;
            }
        }
        
        if(n%2 == 0) {
            return (count == 0) ? 1 : 0;
        }
        else {
            return (count == 1) ? 1 : 0;
        }
    }
}