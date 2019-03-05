/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
*/
class Solution {
    public String intToRoman(int num) {
        if(num < 1)
            return "";
        else if( num > 3999)
            return "M*";
        int closeVal = 0;
        Map<Integer,String> romanMap = new LinkedHashMap<Integer,String>();
        romanMap.put(1,"I");
        romanMap.put(4,"IV");
        romanMap.put(5,"V");
        romanMap.put(9,"IX");
        romanMap.put(10,"X");
        romanMap.put(40,"XL");
        romanMap.put(50,"L");
        romanMap.put(90,"XC");
        romanMap.put(100,"C");
        romanMap.put(400,"CD");
        romanMap.put(500,"D");
        romanMap.put(900,"CM");
        romanMap.put(1000,"M");
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            int key = getCloseRoman(num,romanMap);
            sb.append(romanMap.get(key));
            num = num - key;
        }
        return sb.toString();
    }
    
    private int getCloseRoman(int num, Map<Integer,String> romanMap) {
        int closeVal = 0;
        for(Map.Entry<Integer,String> entry:romanMap.entrySet()) {
            if(entry.getKey() > num)
                return closeVal;
            else
                closeVal = entry.getKey();
        }
        return closeVal;
    }
               
}