/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.


*/
class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        for(int i=0; i < s.length();) {
            StringBuilder sb = new StringBuilder();
            while(i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            result.append(sb.reverse());
            if( i < s.length()) {
             result.append(' ');
                i++;
            }
        }
        return result.toString();
    }
}