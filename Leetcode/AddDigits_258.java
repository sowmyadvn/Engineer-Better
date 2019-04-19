/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?


*/
class Solution {
    public int addDigits(int num) {
        int result = num, sum = 0;
        do {
            while(result != 0) {
                int rem = result%10;
                sum += rem;
                result = result/10;
            }
            result = sum;
            sum = 0;
            
        }while(result > 9);
        
        return result;
    }
}