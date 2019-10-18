/*
Given an array A of positive integers, let S be the sum of the digits of the minimal element of A.

Return 0 if S is odd, otherwise return 1.

 

Example 1:

Input: [34,23,1,24,75,33,54,8]
Output: 0
Explanation: 
The minimal element is 1, and the sum of those digits is S = 1 which is odd, so the answer is 0.
Example 2:

Input: [99,77,33,66,55]
Output: 1
Explanation: 
The minimal element is 33, and the sum of those digits is S = 3 + 3 = 6 which is even, so the answer is 1.
 

Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
*/
class Solution {
    private int sumDigits(int num) {
        int sum = 0;
        while(num != 0) {
            int rem = num%10;
            sum += rem;
            num = num/10;
        }
        return sum;
    }
    public int sumOfDigits(int[] A) {
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++) {
            if(A[i] < result)
                result = A[i];
        }
        return sumDigits(result)%2 == 0?1:0;
    }
}