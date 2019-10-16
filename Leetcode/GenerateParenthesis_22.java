/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generate(result, "",n, 0, 0);
        return result;
    }
    
    private void generate(List<String> list, String st, int max, int open, int close) {
        if(st.length() == max*2) {
            list.add(st);
            st = "";
        }
        if(open < max)
            generate(list,st+"(",max,open+1,close);
        if(close < open) 
            generate(list,st+")",max,open,close+1);
    }
}