/*
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 

Example 1:

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:

Input:
matrix = [
  [1,2],
  [2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
*/
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length;j++) {
                if(matrix[i-1][j-1] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }
}