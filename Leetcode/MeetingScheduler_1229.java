/*Two pointers problem*/
class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int i = 0, j = 0;
        Arrays.sort(slots1,(i1,i2)->Integer.compare(i1[0],i2[0]));
        Arrays.sort(slots2,(i1,i2)->Integer.compare(i1[0],i2[0]));
        List<Integer> res = new ArrayList<Integer>();
        
        while(i < slots1.length && j < slots2.length) {
            int a1 = slots1[i][0], a2 = slots1[i][1];
            int b1 = slots2[j][0], b2 = slots2[j][1];
            int min = a1>b1?a1:b1;
            int max = a2<b2?a2:b2;
            if(max > min && max-min >= duration) {
                res.add(min);
                res.add(min+duration);
                return res;
            }
            else if(a2 > b2) j++;
            else i++;
        }
        return res;
    }
}

/*
Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.  

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 

Constraints:

1 <= slots1.length, slots2.length <= 10^4
slots1[i].length, slots2[i].length == 2
slots1[i][0] < slots1[i][1]
slots2[i][0] < slots2[i][1]
0 <= slots1[i][j], slots2[i][j] <= 10^9
1 <= duration <= 10^6 
*/