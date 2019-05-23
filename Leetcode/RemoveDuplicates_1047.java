/*
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 

Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.
*/
class Solution {
    public String removeDuplicates(String S) {
        boolean unique = false, dlt = false;
        StringBuilder sb = new StringBuilder(S);
        while(!unique) {
            for(int i = 0; i < sb.length()-1;i++) {
                if(sb.charAt(i) == sb.charAt(i+1)) {
                    sb.deleteCharAt(i+1);
                    sb.deleteCharAt(i);
                    dlt = true;
                }
            }
            if(!dlt)
                unique = true;
            else
                dlt = false;
        }
        return sb.toString();
    }
}