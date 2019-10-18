/*
Given a string S, return the number of substrings that have only one distinct letter.

 

Example 1:

Input: S = "aaaba"
Output: 8
Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
"aaa" occurs 1 time.
"aa" occurs 2 times.
"a" occurs 4 times.
"b" occurs 1 time.
So the answer is 1 + 2 + 4 + 1 = 8.
Example 2:

Input: S = "aaaaaaaaaa"
Output: 55
*/
class Solution {
    public int countLetters(String S) {
        if(S.length() <= 1)
            return S.length();
        int count = 1, sum = 0;
        for(int i = 1; i < S.length(); i++) {
        
            if(S.charAt(i) == S.charAt(i-1)) {
                count++;
            } 
            else {
                sum += (count*(count+1))/2;
                count = 1;
            }
                
        }
        sum += (count*(count+1))/2;
        return sum;
    }
}