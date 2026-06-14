
/*

Problem Statement: Given an integer array nums of size n, return the majority element of the array.

The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.*/


package SDESheetChallenge.Arrays;

import java.util.HashMap;
import java.util.Map;

public class Majority1 {

}

//BRUTE SOlUTION
/*Iterate through the array to select each element one by one.
For each selected element, run another loop to count its occurrences in the given array.
If the occurrence of any element is greater than the floor of (N/2), return that element immediately as the majority element.*/

class Majority_BRUTESolution {

    public int majorityElement(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n; i++) {

            int count = 0;

            for(int j = 0; j < n; j++) {

                if(nums[i] == nums[j]) {
                    count++;
                }
            }

            if(count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }
}



//BETTER APPROACH
/*Using hashmap*/


class Majority_BETTERSolution{
    public int majorityElement(int[] nums) {

        Map<Integer,Integer> freq = new HashMap<>();

        int n = nums.length;

        for(int num : nums) {

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            if(freq.get(num) > n / 2){
                return num;
            }
        }

        return -1;
    }
}



//OPTIMAL APPROACH

// This below is called as MOORE'S VOTING ALGORITHM
/*Initialize two variables: count to track the count of elements, and element to keep track of the element being counted.
Traverse through the given array. If count is 0, store the current value of the array as element.
If the current element in the array is the same as element, increment the count by 1.
If the current element is different from element, decrement the count by 1.
At the end of the traversal, the integer stored in element will be the expected result (the majority element).*/

class Majority_OptimalSolutiin{
	 public int majorityElement(int[] nums) {
		 
		 int count=0;
		 
		 int ele =0;
		 
		 for(int i = 0;i< nums.length;i++) {
			 if(count ==0) {
				 count = 1;
				 ele = nums[i];
			 }
			 else if(nums[i]== ele) {
				 count++;
			 }
			 else {
				 count--;
			 }
		 }
		 
		 int count_= 0;
		 
		 for(int i = 0;i< nums.length;i++) {
			 if(nums[i] == ele) {
				 count_++;
				 
			 }
		 }
		 if(count_> nums.length/2) {
			 return ele;
		 }
		 
		 
		 return -1;
	 }
	 
}
