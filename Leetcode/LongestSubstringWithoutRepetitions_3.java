/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        if (s.length() < 2)
            return s.length();
        
        for(int i = 0; i < s.length(); i++) {
            //Check if char is present in StringBuilder. Append if not present
            if(sb.toString().indexOf(s.charAt(i)) == -1) {
                sb.append(s.charAt(i));
                
            }
            //If present, then delete string builder substring till that character and append new char to stringbuilder
            else {
                if (count < sb.length())
                    count = sb.length();
                sb.delete(0,sb.toString().indexOf(s.charAt(i))+1);
                sb.append(s.charAt(i));
            }
        }
        
        //Corner case where longest substring is in the end till s.length()-1
        if (count < sb.length())
                    return sb.length();
        return count;
    }
}

/*
Approach: StringBuilder is used to append new characters to determine longest substring. Count variable stores previous sub string's length, so that new builder's length can be compared to the previous one. 
*/
