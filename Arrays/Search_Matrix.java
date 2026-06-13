/*
 * Search in a sorted 2D matrix


Problem Statement: You have been given a 2-D array 'mat' of size 'N x M' where 'N' and 'M' denote the number of rows and columns, respectively. 
The elements of each row are sorted in non-decreasing order. Moreover, the first element of a row is greater than the last element of the previous row (if it exists). 
You are given an integer ‘target’, and your task is to find if it exists in the given 'mat' or not.*/


package SDESheetChallenge.Arrays;

public class Search_Matrix {

}
//BRUTE APPROACH:
/*use two nested for loops*/
class Brute_Solution{
	public boolean searchMatrix(int[][] matrix, int target) {
	int n = matrix.length;
	int m = matrix[0].length;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (matrix[i][j] == target)
                return true;
		}
	}
	// Return false if the target is not found
    return false;
}
}


//BETTER SOLUTION:
/*1. Traverse each row and find the row where:
   matrix[i][0] <= target <= matrix[i][m-1]

2. Once such a row is found, apply Binary Search on that row.

3. If Binary Search finds target → return true, else return false.*/

class BETTER_Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i =0; i< r; i++){
            if(matrix[i][0]<= target && matrix[i][c-1]>= target){
                if(binarysearch(matrix[i],target)){
                    return true;
                };
            }
        }
        return false;
        
        
    }

    private boolean binarysearch(int[]matrix, int target){
        int low = 0;
        int high = matrix.length-1;
        
        while(low <= high){
        int mid = (low + high)/2;
        if(matrix[mid] == target){
            return true;
        }
        else if(matrix[mid] <  target){
            low = mid+1;
        }
        else{
            high = mid-1;
        }
   }
   return false;
    
}
}



//OPTIMAL SOLUTION
/*1. Treat the matrix as a sorted 1D array of size (rows × cols).

2. Apply Binary Search on indices [0 ... rows*cols - 1].

3. Convert mid to matrix position:
   row = mid / cols, col = mid % cols.*/


class Optimal_Solution{
	 public boolean searchMatrix(int[][] matrix, int target) {
		 int n = matrix.length;
		 int m = matrix[0].length;
		 int low = 0, high = n * m - 1;
		 
		
	        while (low <= high) {
	            int mid = (low + high) / 2;

	            // Map 1D index to 2D coordinates
	            int row = mid / m;
	            int col = mid % m;
	            
	            if (matrix[row][col] == target)
	                return true;
	     
	            else if (matrix[row][col] < target)
	                low = mid + 1;
	            else
	                high = mid - 1;
	        }

	        return false;
	    
	
	 }
}
