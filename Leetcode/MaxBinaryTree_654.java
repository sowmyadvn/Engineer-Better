/**
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0, nums.length);
    }
    
    private TreeNode construct(int[] nums, int l, int r) {
        if(l == r)
            return null;
        int max = calcMax(nums,l,r);
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums,l,max);
        root.right = construct(nums, max+1, r);
        return root;
    }
    
    private int calcMax(int[] nums, int l, int r) {
        int max = l;
        for(int i = l; i < r; i++) {
            if(nums[max] < nums[i])
                max = i;
        }
        return max;
    }
}