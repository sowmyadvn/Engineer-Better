/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int  place = nums1.length-1;
        int i = 0, j = 0;
        for(i = m-1, j = n-1; i >= 0 && j >= 0; ) {
            if(nums2[j] > nums1[i]) {
                nums1[place--] = nums2[j];
                j--;
            }
            else {
                nums1[place--] = nums1[i];
                i--;
            }
        }
        
        while(j != -1) {
            nums1[j] = nums2[j];
            j--;
        }
        
    }
}

/*
Approach: Because it is in-place, we can compare from end to beginning
So, [1,2,3,0,0,0],[2,5,6] => Compare 6 and 3, place 6 and decerement nptr
[1,2,3,0,0,6],[2,5,6] => Compare 5 and 3, place 5 and decr nptr
[1,2,3,0,5,6],[2,5,6] => Compare 2 and 3, 2 < 3, so move 3 to 4-ind and decr mptr
Place 2, so [1,2,2,3,5,6]

if [1,2,0, 0,0] and [-1,0,5] => [1,2,0,0,5],[-1,0,5] => [1,2,1,2,5],[-1,0,5] => 
*/