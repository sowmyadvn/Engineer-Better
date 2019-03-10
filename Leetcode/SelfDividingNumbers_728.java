/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.
*/
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int num = left; num <= right; num++) {
            if(num < 10)
                list.add(num);
            else {
                int x = num;
                while(x > 0 && x%10 != 0) {
                    int i = x%10;
                    if(num%i == 0) { 
                        x = x/10;
                    }
                    else
                        x = -1;
                }
                if(x == 0)
                    list.add(num);
            }
        }
        return list;
    }
}