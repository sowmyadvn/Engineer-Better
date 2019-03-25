/*
Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.
*/
class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        List<Integer> ci = new ArrayList<Integer>();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C)
                ci.add(i);
        }
        int j = 0;
        for(int i = 0; i < S.length(); i++) {
            if(j < ci.size()-1) {
                if(Math.abs(ci.get(j)-i) < Math.abs(ci.get(j+1)-i)) {
                    result[i] = Math.abs(ci.get(j) - i);
                }
                else {
                    result[i] = Math.abs(ci.get(j+1)-i);
                    j++;
                }
            }
            else {
                result[i] = Math.abs(ci.get(j)-i);
            }
        }
        return result;
    }
}