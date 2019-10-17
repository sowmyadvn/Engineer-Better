/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length() == 0)
            return list;
        String[] dict = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
         generate(list,digits.toCharArray(),dict,"");
        return list;
    }
    private void generate(List<String> list, char[] digits,String[] dict, String s) {
       if(s.length() == digits.length) {list.add(s); return;}
       int i = s.length();
       int digit = digits[i]-'0';
        
       for (char letter : dict[digit].toCharArray()) {
            generate(list, digits, dict, s + Character.toString(letter));
        }
    }
    
}