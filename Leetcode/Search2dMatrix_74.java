
// Time Complexity : O(M + log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

/*
Approach:
========
1. Iterate through each row and check for boundaries of row for the target
2. If within boundaries of the row, perform binary search on that row. 
3. If found, return true. If not, return false as element cannot be in the next row
*/

// Your code here along with comments explaining your approach

class Solution {
    int m,n;
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0) return false;
        
        m = matrix.length; n = matrix[0].length;
        if( m > 0 && n > 0 && (matrix[0][0] > target || matrix[m-1][n-1] < target)) return false; //target doesn't exist in matrix
        int i = 0;
        while (i < m) { 
            if(n > 0 && matrix[i][0] <= target && matrix[i][n-1] >= target)  // check if target exists in boundaries of row
                return binarySearch(matrix,i, target); // If found, perform binary search on the row
            i++;
        }  
        return false;
    }
    
    private boolean binarySearch(int[][] matrix, int i, int target) {
        int low = 0, high = n-1; 
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(matrix[i][mid] == target) {   // target found in matrix   
                return true;
            }
            else if( matrix[i][mid] < target)  //search on right side, so update low
                low = mid + 1;
            else                            //search on left side, so update high
                high = mid - 1;
        }
        return false;
    }
}