class Solution {
    public int subtractProductAndSum(int n) {
        if(n < 10) 
            return 0;
        int cur = 0;
        int prod = 1, sum = 0;
        while(n > 0) {
            cur = n%10;
            prod *= cur;
            sum += cur;
            n = n/10;
        }
        return prod-sum;
    }
}
/*
Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 

Example 1:

Input: n = 234
Output: 15 
Explanation: 
Product of digits = 2 * 3 * 4 = 24 
Sum of digits = 2 + 3 + 4 = 9 
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation: 
Product of digits = 4 * 4 * 2 * 1 = 32 
Sum of digits = 4 + 4 + 2 + 1 = 11 
Result = 32 - 11 = 21
*/