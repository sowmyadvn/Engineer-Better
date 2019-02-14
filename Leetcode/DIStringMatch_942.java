/*
Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]
*/
class Solution {
    public int[] diStringMatch(String S) {
        int[] arr = new int[S.length()+1];
        int low = 0, high = S.length();
        if(S.charAt(0) == 'I') {
            arr[0] = 0;
            low++;
        }
        else {
            arr[0] = S.length();
            high--;
        }
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] == 'I')
                arr[i+1] = high--;
            else
                arr[i+1] = low++;
        }
        return arr;
    }
}

/*
Approach: Keep track of low and high, When I, assign highest, if D lowest
*/