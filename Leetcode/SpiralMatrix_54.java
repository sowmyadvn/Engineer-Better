// Time Complexity : O(MN)
// Space Complexity : O(min(M,N)) for recursive and O(1) for iterative
// Did this code successfully run on Leetcode : yes

/*
Approach:
1. As soon as we see the question, it is clear that we need to play with boundaries to get the spiral order
2. Shrink the boundaries of the matrix as we iterate through top row,right column , bottom row and left column in respective order
3. Most important step here is to check if top crosses bottom when iterating through rightmost column and if left crossed right when iterating through leftmost column, as we have updated them in previous two steps
*/

// ========================== Recursive approach =================================
class Solution {
    
    List<Integer> result;
    public List<Integer> spiralOrder(int[][] matrix) {
        result = new ArrayList<>();
        if( matrix == null || matrix.length == 0) return result;
        
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        helper(matrix, left, right, top, bottom);
        return result;
    }
    
    private void helper(int[][] matrix, int left, int right, int top, int bottom) {
        // base case
        if( left > right || top > bottom) return;
        // logic
        
        if( left <= right && top <= bottom) {
            // iterating left to right, so row is top
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            // iterating top to bottom, so column is right
            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // iterating right to left, so row is bottom 
            if( top <= bottom) {
                for(int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // iterating bottom to top, so column is left
            if( left <= right) {
                for(int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
         helper(matrix, left, right, top, bottom);
        
    }
}

// ========================== Iterative approach =================================

class Solution {
    
    List<Integer> result;
    public List<Integer> spiralOrder(int[][] matrix) {
        result = new ArrayList<>();
        if( matrix == null || matrix.length == 0) return result;
        
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        while ( left <= right && top <= bottom) {
            // iterating left to right, so row is top
            for(int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            // iterating top to bottom, so column is right
            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // iterating right to left, so row is bottom 
            if( top <= bottom) {
                for(int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // iterating bottom to top, so column is left
            if( left <= right) {
                for(int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<Integer>();
        int minI = 0, minJ = 0, maxI = matrix.length-1, maxJ = matrix[0].length-1;
        int k = 0;
        List<Integer> arr = new ArrayList<Integer>();
        while(minI <= maxI && minJ <= maxJ) {
            for(int j = minJ; j <= maxJ; j++)
                arr.add(matrix[minI][j]);
            minI++;
            for(int i = minI; i <= maxI; i++)
                arr.add(matrix[i][maxJ]);
            maxJ--;
           if(minI <= maxI) {
                for(int j = maxJ; j >= minJ; j--)
                    arr.add(matrix[maxI][j]);
                maxI--;
           }
           if(minJ <= maxJ) { 
                for(int i = maxI; i >= minI; i--)
                    arr.add(matrix[i][minJ]);
                minJ++;
           }
        }
        return arr;
    }
}



/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/