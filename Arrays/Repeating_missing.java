/*
 * Find the repeating and missing numbers


Problem Statement: Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

Note: You are not allowed to modify the original array.*/




package SDESheetChallenge.Arrays;

public class Repeating_missing {

}


/*BRUTE FORCE
 * Iterate through the array from index 1 to N, where N is the size of the array.
For each integer, i, use linear search to count its occurrence in the given array.
If an element has an occurrence of 2, store it as a candidate element.
If an element has an occurrence of 0, store it as another candidate element.
Finally, return the two elements that have occurrences of 2 and 0, respectively.*/

class Brute_Solution{
	public int[] findMissingRepeatingNumbers(int[] nums) {
		int n = nums.length;
		int repeating = -1;
		int missing = -1;
		
		// Find the repeating and missing number:
		for(int i = 1; i<=n; i++) {
			 // Count the occurrences:
			int count = 0;
			for(int j = 0; j<n; j++) {
				if(nums[j] == i) {
					count++;
				}
				//Check if i is repeating or missing
				if(count ==2) {
					repeating = i;
				}
				else if(count ==0) {
					missing = i;
				}
				
				//Stop early if both found
				if(repeating != -1 && missing != -1) {
					break;
				}
				
				//Return repeating and missing
				return new int[] {repeating,missing};
			}
		}
		return new int[] {};
		}
	
}


//Better Solution
/*
 * we will use a hash array to count frequncy of element of length N+1, as number is [1,N], so we give index total N+1*/
/*Iterate through the given array and for each element encountered, update the frequency in the hash array.
Once all elements are processed, iterate through the hash array and identify the two elements: one with frequency 2 and one with frequency 0.
Return the two elements that have frequencies of 2 and 0, respectively.
*/


class Better_Solution{
	 public int[] findMissingRepeatingNumbers(int[] nums) {
	int n = nums.length;
	int[]  hash= new int[n+1];
	for(int i=0; i<n; i++) {
		hash[nums[i]]++;
	}
	
	int repeat= -1;
	int miss = -1;
	for(int i = 1; i<=n;i++) {
		if(hash[i] ==2) {
			repeat = i;
		}
		else if(hash[i] ==0) {
			miss = i;
		}
		
		if(repeat != -1 && miss != -1) {
			break;
		}
	}
	return new int[] {repeat,miss};
	
}
}


//OPTIMAL SOLUTION 01
/* We will use concept of sum of first n natural number and its sum of first n squre.*/

class Optimal_math_solution{
	 public int[] findMissingRepeatingNumbers(int[] nums) {
		 int n = nums.length;

	        long S = 0;
	        long S2 = 0;

	        for (int i = 0; i < n; i++) {
	            S += nums[i];
	            S2 += (long) nums[i] * nums[i];
	        }

	        long SN = (long) n * (n + 1) / 2;
	        long S2N = (long) n * (n + 1) * (2 * n + 1) / 6;

	        long val1 = S - SN;       // x - y
	        long val2 = S2 - S2N;     // x² - y²

	        val2 = val2 / val1;       // x + y

	        int repeat = (int) ((val1 + val2) / 2);
	        int miss = (int) (repeat - val1);

	        return new int[]{repeat, miss};
	    }
}
		

