// Time: O(N^2) where N is given
// Space: O(1) as we aren't using additional auxilliary space, other than the result

/* 
Approach:
1. Use 4 variables to keep track of row and column values. 
2. When top and bottom (or) left and right cross, means all of the values are filled
3. Use count variable to help fill from 1 to n^2. As top and right values are changed, when filling rightmost and bottommost column and row respectively, "MUST MUST" check for boundaries to prevent exceptions
*/
class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0) return new int[0][0];
        int[][] result = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int ct = 1;
        while ( top <= bottom && left <= right) {
            // iterating left to right, so top row is constant
            for(int i = left; i <= right; i++) {
                result[top][i] = ct++;
            }
            top++;
            
            // iterating top to bottom on right most column, so right is constant
            for(int i = top; i <= bottom; i++) {
                result[i][right] = ct++;
            }
            right--; 
            
            // as right and top changed, check boundaries for next 2 conditions to prevent getting duplicate values
            // iterate right to left, so check if that row is already done by comparing top and bottom, bottom is constant here
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                result[bottom][i] = ct++;
                }
                bottom--;
            }
            
            // iterate bottom to top, so check if that column is already visited by comparing left and right, left is constant here
            if( left <= right) {
                for(int i = bottom; i >= top; i--) {
                result[i][left] = ct++;
                }
                left++;
            }
        }
        return result;
    }
}