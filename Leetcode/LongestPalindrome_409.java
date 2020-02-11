// Time Complexity : O(N) where N is the string size
// Space Complexity : O(1) because maximum size of set can only be 52 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.


Algorithm:
==========
1. Use hashset to store characters and if same character is in the set, increment count by 2.
2. Finally, if set is empty return count, if not return count+1 as an additional char can be added to make it large palindrome
*/

class Solution {
    
    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        
        // If set already has character, remove it and increment count by 2
        for( char c: s.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
            }
            else {
                set.remove(c);
                count += 2;
            }
        }
        
        //If empty, count is the max palindrome size, where as if not, an extra char can be added in the middle
        return set.isEmpty()?count:count+1;
    }
}
