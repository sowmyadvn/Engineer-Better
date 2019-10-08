/*
Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.

 

Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.
 

Constraints:

1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000
*/
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < arr1.length; i++) {
            boolean two = false, three = false;
            for(int j = 0; j < arr2.length && arr2[j] <= arr1[i]; j++) {
                if(arr1[i] == arr2[j]) {
                    two = true;
                }
            }
            for(int k = 0; k < arr3.length && arr3[k] <= arr1[i]; k++) {
                if(arr1[i] == arr3[k]) {
                    three = true;
                }
            }
            if(two && three)
                arr.add(arr1[i]);
        }
        return arr;
    }
}

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0, k = 0;
        while(i < arr1.length && j < arr2.length && k < arr3.length) {
            if(arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            }
            else if(arr1[i] < arr2[j]) {
                i++;
            }
            else if(arr2[j] < arr3[k]) {
                j++;
            }
            else 
                k++;
        }
        return result;
    }
}