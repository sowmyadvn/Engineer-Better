/*
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
*/
class Solution {
    public List<String> commonChars(String[] A) {
        //New list to store common chars
        List<String> strList = new ArrayList<String>();
        if(A.length == 0)
            return strList;
        //Store first string's chars in the result list because common chars cannot be more than this
        for(char c: A[0].toCharArray()) {
            String s = Character.toString(c);
            strList.add(s);    
        }
        //Check if every other string has this character, if not remove from final List and reduce index
        for(int i = 1; i < A.length; i++) {
            StringBuilder sb = new StringBuilder(A[i]);
            for(int j = 0; j < strList.size();j++) {
                String s = strList.get(j);
                if(sb.indexOf(s) != -1) {
                    sb.delete(sb.indexOf(s),sb.indexOf(s)+1);
                }
                else {
                    strList.remove(j);
                    j--;
                }
            }
                
        }
        return strList;
    }
}
