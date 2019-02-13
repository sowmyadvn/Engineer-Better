/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.

*/
class Solution {
    public int[] sortedSquares(int[] A) {
        int num = A[0];
        for(int i = 0; i < A.length; i++) {
            A[i] = A[i]*A[i];
        }
        if(num >= 0)
            return A;
        else {
            Arrays.sort(A);
            return A;
        }
     }
}

/*
Approach: Square and sort. O(N^2) worst case complexity. O(1) space
*/

class Solution {
    public int[] sortedSquares(int[] A) {
        if(A.length == 0)
            return A;
        int[] arr = new int[A.length];
        int i = 0, k = 0;
        while(i < A.length && A[i] < 0) {
            i++;
        }
        int j = i;
        i = i-1;
        while(i >= 0 && j < A.length) {
            if(Math.abs(A[i]) < Math.abs(A[j])) {
                arr[k++] = A[i]*A[i];
                i--;
            }
            else {
                arr[k++] = A[j]*A[j];
                j++;
            }
        }
        while(j < A.length) {
            arr[k++] = A[j]*A[j];
                j++;
        }
        
        while(i >= 0) {
            arr[k++] = A[i]*A[i];
            i--;
        }
        return arr;
    }
}

/*
Approach: two pointer solution, i - negative value pointer, j - positive value pointer
*/