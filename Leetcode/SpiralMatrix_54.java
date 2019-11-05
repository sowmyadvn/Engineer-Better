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