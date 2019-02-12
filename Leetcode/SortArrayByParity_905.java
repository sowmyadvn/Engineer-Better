/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

*/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A.length <= 1)
            return A;
        int[] result = new int[A.length];
        int j = 0,k = A.length-1;
        for(int i = 0; i < A.length; i++) {
            if(A[i]%2 == 0)
                result[j++] = A[i];
            else
                result[k--] = A[i];
        }
        return result;
    }
}
/*
Iterate through array, store even numbers from front and odd numbers from back into new array. O(A)S:O(A)T
*/