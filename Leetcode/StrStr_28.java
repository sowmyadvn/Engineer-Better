/*Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

*/

// ============= Using built-in indexof ========================

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// ================ Without using indexOf ========================

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) return -1;
        
        int nsize = needle.length();
        int start = 0, end = nsize;
        while(end <= haystack.length()) {
            if(haystack.substring(start, end).equals(needle))
                return start;
            start++;
            end++;
        }
        return -1;
    }
}