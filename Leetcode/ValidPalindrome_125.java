/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/
class Solution {
    public boolean isPalindrome(String s) {
        String r = s.replaceAll("[^0-9A-Za-z]","").toLowerCase();
        int high = r.length()-1;
        int mid = r.length()/2;
        for(int i = 0; i < mid; i++) {
            if(r.charAt(i) != r.charAt(high-i))
                return false;
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return true;
        s= s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String pal = new StringBuilder(s).reverse().toString();
        return s.equals(pal);
        
    }
}