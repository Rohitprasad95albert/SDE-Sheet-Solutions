
//QUESTION
/*Find the duplicate in an array of N+1 integers


Problem Statement: Given an array of N + 1 size, where each element is between 1 and N. Assuming there is only one duplicate number, 
your task is to find the duplicate number.*/


package SDESheetChallenge.Arrays;

import java.util.Arrays;

public class duplicate_find {


}
class BRUTE_Solution {
	/*BRUTE FORCE APPROACH
	 * STEP1:- Sort the array
	 * STEP2: if a[i] = a[i+1], then store or return a[i]*/
	
    public static int findDuplicate(int[] nums) {
    	 // sort array in-place
          Arrays.sort(nums);
          int n = nums.length;
          for(int i = 0; i<n-1;i++ ) {
        	  if(nums[i] == nums[i+1]) {
        		  return nums[i];
        	  }
          }
          return -1;
		
        
    }
}


class BETTER_Solution{
	/*BETTER APPROACH
	 * STEP1: Create a freq array of having all element ==0
	 * traverse array and record its freq, if freq greter 1 then return*/
	
	public static int findDuplicate(int[] nums) {
		int n = nums.length;
		// allocate frequency array initialized to 0
        int[] freq = new int[n + 1];
        
        // traversing array
        for(int i=1; i< n; i++) {
        	if(freq[nums[i]]==0) {
        		freq[nums[i]]++;
        	}
        	else if(freq[nums[i]]==1) {
        		return nums[i];
        	}
        }
        
     // fallback if none (per original)
		return -1;
		
	}
}


class OPTIMAL_Solution{
	// find the duplicate using cycle detection
    static int findDuplicate(int[] nums) {
    	int slow = nums[0];
    	int fast = nums[0];
    	
    	 // move slow by 1 step and fast by 2 steps until they meet
    	do {
    		slow = nums[slow];
    		fast = nums[nums[fast]];
    	}
    	while(slow != fast);
    	
    	// reset fast to start to find the entrance to the cycle
        fast = nums[0];
        
        // move both by 1 step until they meet at the duplicate
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        // return the duplicate value
        return slow;
    	
        // initialize pointers at the start
    }
}


/*
 * // separate main class
public class Main {
    // program entry
    public static void main(String[] args) {
        // initialize input
        int[] arr = new int[]{1, 3, 4, 2, 3};

        // compute and print result
        System.out.println("The duplicate element is " + CLASSNAME.findDuplicate(arr));
    }
}*/
