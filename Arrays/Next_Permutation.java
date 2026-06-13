//next_permutation : find next lexicographically greater permutation


/*

Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).

*/
package SDESheetChallenge.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Next_permutation {

}

class NP_Brute_solution{
	// Function to find the next permutation
    public List<Integer> nextPermutation(int[] nums) {
        // List to hold all permutations
        List<List<Integer>> all = new ArrayList<>();

        // Sort the input to start from the smallest
        Arrays.sort(nums);

        // Generate all permutations
        permute(nums, 0, all);

        // Convert array to list for comparison
        List<Integer> current = new ArrayList<>();
        for (int num : nums)
            current.add(num);

        // Find and return the next permutation
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(current)) {
                if (i == all.size() - 1)
                    return all.get(0);
                return all.get(i + 1);
            }
        }

        return current;
    }

    // Backtracking permutation generator
    private void permute(int[] nums, int start, List<List<Integer>> all) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            all.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, start + 1, all);
            swap(nums, i, start);
        }
    }

    // Swap helper
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}



//Optimal Approach
/*
 * STEP1:-Traverse from the end and find the first index where  the current digit is smaller than the next one
 * STEP2:-again traverse from the end to find the first digit greater than the breaking point digit and swap them.
 * STEP3:Finally, reverse the part of the array to the right of the breaking point to get the smallest next permutation.
 * STEP4: if no such breaking points found(i.e entire array is desecnding), just reverse whole array.*/

class NP_Optimal_Solution{
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int idx = -1;
		for(int i = n-1; i> 0;i--) {
			if(nums[i]> nums[i-1]) {
				idx = i-1;
				break;
				
			}
		}
		for(int i = n-1; i>= 0;i--) {
			if(nums[i]> nums[idx]) {
				int temp = nums[i];
				nums[i] = nums[idx];
				nums[idx]= temp;
				
				break;
			}
			
			
		}
		if(idx == -1) {
			reverse(nums,0);
		}
		reverse(nums,idx+1); //after swapping, we need to reverse the suffix after the pivot.so +1
        
    }
	public static void reverse(int[] arr, int start) {

	    int left = start;
	    int right = arr.length - 1;

	    while(left < right) {
	        int temp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = temp;

	        left++;
	        right--;
	    }
	}
}


// T.C O(n), S.C O(1)
