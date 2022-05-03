class Solution {
    
    double myPowUtil(double x, long ln) {
        if(ln == 1) {
            return x;
        }
        
        double res = myPowUtil(x, ln/2);
        
        if(ln%2 == 0) {
            return res*res;
        }
        
        return res*res*x;
    }
    
    public double myPow(double x, int n) {
        long ln = (long) n;
        if(x == 0 || x == 1)
            return x;
        
        if(ln < 0) {
            return myPowUtil(1/x, -1*ln);
        }
        else if(ln > 0) {
            return myPowUtil(x, ln);
        }
        else {
            return 1;
        }
    }
}