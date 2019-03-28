/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.

Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
*/
```
class Solution {
    public String[] findWords(String[] words) {
        String[] rows = new String[3];
        //Three rows of keyboard characters stored in array of strings
        rows[0] = "qwertyuiopQWERTYUIOP";
        rows[1] = "asdfghjklASDFGHJKL";
        rows[2] = "zxcvbnmZXCVBNM";
        List<String> strList = new ArrayList<String>();
        for(String s: words) {
            int j = 0, row = 0;
            boolean rowsChecked = false;
            //rowsChecked = true if all rows are checked and string is evaluated
            while(!rowsChecked) {
                int i = 0;
                for(i = 0; i < s.length() && j < rows.length;) {
                    String c = ""+s.charAt(i);
                    //If char in row, check next char
                    if(rows[j].contains(c))
                        i++;
                    //If char not in row, increment row and check from first in next Row
                    else {
                        j++;
                        i = 0;
                    }
                    
                }
                if(i == s.length()) {
                    strList.add(s);
                }
                rowsChecked = true;
            }
        }
        return strList.toArray(new String[strList.size()]);
    }
}
```