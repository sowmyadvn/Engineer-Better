class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        // edge case 
        if( matrix == null || matrix.length == 0) return new int[0];
        
        int m = matrix.length, n = matrix[0].length;
        // to accommodate all elements in matrix, array size should be m*n
        int[] result = new int[m*n];
        
        // to keep track of direction of diagonal traversal
        boolean up = true;
        int row = 0, col = 0;
        
        for(int i = 0; i < result.length; i++) {
            result[i] = matrix[row][col];
            if(up) {
                //Reached last column - move down
                if(col == n - 1) {
                    up = false;
                    row++; 
                }
                //reached first row - move down
                else if(row == 0) {
                    up = false;
                    col++;
                }
                // keep moving up diagonally
                else {
                    row--; 
                    col++;
                }
            }
            else {
                // reached last row - move up
                if( row == m - 1) {
                    up = true;
                    col++;
                }
                //reached first column - move up
                else if( col == 0) {
                    up = true;
                    row++;
                }
                // keep moving down diagonally
                else {
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}