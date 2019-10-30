/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321. 
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len-1] != 9) {
            digits[len-1]++;
            return digits;
        }
        int i = 1;
        while( i <= len && digits[len-i] == 9) {
            digits[len-i] = 0;
            i++;
        }
        if( digits[0] == 0) {
            int[] result = new int[len+1];
            result[0] = 1;
            for(int k = 1; k < len+1; k++)
                result[k] = 0;
            return result;
        }
        else
            digits[len-i]++;
    
        return digits;
        
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<Integer>();
        int rem = 1;
        for(int i = digits.length-1;i >= 0; i--) {
            if(rem == 1) {
                int tot = rem+digits[i];
                rem = (tot >=10)?1:0;
                list.add(0,tot%10);
            }
            else 
                 list.add(0,digits[i]);
        }
        if(rem == 1)
            list.add(0,1);
        int[] arr = new int[list.size()];
        int j = 0;
        for(int i=0; i < list.size();i++)
            arr[j++] = list.get(i);

        return arr;
    }
}