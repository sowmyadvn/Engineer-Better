/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
*/
class Solution {
    public int titleToNumber(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>() {
            {
                put('A',1);
                put('B',2);
                put('C',3);
                put('D',4);
                put('E',5);
                put('F',6);
                put('G',7);
                put('H',8);
                put('I',9);
                put('J',10);
                put('K',11);
                put('L',12);
                put('M',13);
                put('N',14);
                put('O',15);
                put('P',16);
                put('Q',17);
                put('R',18);
                put('S',19);
                put('T',20);
                put('U',21);
                put('V',22);
                put('W',23);
                put('X',24);
                put('Y',25);
                put('Z',26);
                
            }
        };
        int j = 1, result = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            result += j*map.get(s.charAt(i));
            j = j*26;
        }
        return result;
    }
}