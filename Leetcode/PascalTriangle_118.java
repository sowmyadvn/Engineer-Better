class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        curr.add(1);
        for(int j = 0; j < numRows; j++) {
            pascal.add(curr);
            prev = new ArrayList<>(curr);
            curr = new ArrayList<>();
            curr.add(1);
            for(int i = 0; i < prev.size()-1;i++) {
                curr.add(prev.get(i)+prev.get(i+1));
            }
            curr.add(1);
        }
        return pascal;
    }
}
/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        for(int i = 0; i < numRows;i++) {
            curr.add(0,1);
            for(int j = 1; j < curr.size()-1;j++) {
                curr.set(j,curr.get(j)+curr.get(j+1));
            }
            pascal.add(new ArrayList<Integer>(curr));
        }
        return pascal;
    }
}