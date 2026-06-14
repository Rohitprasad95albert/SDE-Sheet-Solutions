/*Implement Pow(x,n) | X raised to the power N


Problem Statement: Implement the power function pow(x, n) , which calculates the x raised to n i.e. xn.*/




package SDESheetChallenge.Arrays;

public class Power {

}

//----BRUTE APPROACH----
/*
 * check if n is postive or negative
 * if negative, then n=-n, and x = 1/x
 * */

//--using iteration--
// T.C = O(n), S.C= O(1)
class Pow_BruteITESolution{
	public double myPow(double x, int n) {
		double ans = 1.0;
		if(n==0) {
			return 1.0; 
		}
		
		if(n < 0) {
			n = -n;
			x  = 1/x;
		}
		for(int i = 0; i< n; i++) {
			ans = ans* x;
		}
		return ans;
	}
}


//--using recurrsion--
// T.C = O(n), S.C= O(n)

class Pow_BruteRECSolution {

    public double myPow(double x, int n) {

        long N = n;

        if(N < 0) {
            x = 1 / x;
            N = -N;
        }

        return power(x, N);
    }

    private double power(double x, long n) {

        if(n == 0)
            return 1.0;

        return x * power(x, n - 1);
    }
}


//----OPTIMAL APPROACH---
//T.c = O(logn)

class Pow_OptimalSolution{
	public double myPow(double x, int n) {
		
	        double ans = 1.0;
	        long N = n;
	        if(N < 0){
	            N = -1*N;

	        }
	        
	        while(N > 0){
	            if( N% 2== 0){
	                x = x*x;
	                N = N /2;
	            }
	            else{
	                ans = ans*x;
	                N = N-1;
	            }
	        }
	        if(n<0){
	            ans =(double)(1.0)/ans;
	        }
	    return ans;
	    }
	    
	
}
