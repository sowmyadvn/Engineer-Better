/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

Example:

Input: s = "++++"
Output: 
[
  "--++",
  "+--+",
  "++--"
]
Note: If there is no valid move, return an empty list [].
*/
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        if(s == null || s.length() <= 1)
            return new ArrayList<String>();
        //O()
        List<String> strList = new ArrayList<String>();
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) == '+' && s.charAt(i) == '+') {
                char[] state = s.toCharArray();
                state[i-1] = '-';
                state[i] = '-';
                strList.add(new String(state));
            }
        }
        return strList;
    }
}

/*
Approach: Save state to list whenever i-1 and i indices have a '+'. 
*/