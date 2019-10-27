class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr1.length == 0 || arr2.length == 0)
            return arr1;
        Map<Integer,Integer> map = new TreeMap<>();
        //Store all values of arr1 with count in tree map
        for(int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        //Update arr1 based on order of arr2 values
        int j = 0;
        for(int i = 0; i < arr2.length; i++) {
            int val = map.get(arr2[i]);
            while(val != 0) {
                arr1[j++] = arr2[i];
                val--;
            }
            map.remove(arr2[i]);
        }
        //Update other values in ascending order in the end
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int val = entry.getValue();
            while(val != 0) {
                arr1[j++] = entry.getKey();
                val--;
            }
        }
        return arr1;
    }
}
/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
 

Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
*/