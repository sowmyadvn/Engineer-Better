/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
[−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

class Solution {
    public int reverse(int x) {
        if ( x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE || x==0)
            return 0;
        int neg = 0;
        if ( x < 0)
            neg = 1;
        x = Math.abs(x);
        int reverse = 0, reminder = 0, temp = x;
        //Mod and div to calculate reverse
        while (temp != 0) {
            reminder = temp%10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE/10 && reminder > 7))
                return 0;
            reverse = reverse*10+reminder;
            temp = temp/10;
        }
        return neg == 0? reverse: -reverse;
    }
}

/*
Approach: This is divide and mod approach of reversing a number. Only important thing to remember is to check overflow. 
If max value/10 < rev, then that means rev is going to be more than int can handle in the next step, because we multiply by 10.
Either that, or if equal to rev and then reminder is 7, sum would be more than int can be stored.
*/