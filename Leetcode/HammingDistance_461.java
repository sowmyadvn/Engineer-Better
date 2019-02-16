/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

*/
class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        String zstr = Integer.toBinaryString(z);
        int count = 0;
        for(int i = 0; i < zstr.length();i++) {
            if(zstr.charAt(i) == '1')
                count++;
        }
        return count;
    }
}

/*
Approach: If xor'ed result of two integers has n bits set, then different bits in x and y are in n positions
O(1)S:O(Z)T where 
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        String zstr = Integer.toBinaryString(z);
        return Integer.bitCount(z);
    }
}