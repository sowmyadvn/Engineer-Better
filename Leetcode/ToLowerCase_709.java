/*
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
*/
class Solution {
    public String toLowerCase(String str) {
        StringBuilder strbldr = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int num = (int)ch;
            if(num >= 65 && num <= 90)
                 ch = (char)(num+32);
            strbldr.append(ch);
        }
        return strbldr.toString();
    }
}

/*
Approach: As strings are immutable in Java, use string buffer and check ascii values.Append ascii+32 (corresponding small
letter instead of upper case letter) O(N)S:O(N)T
*/

