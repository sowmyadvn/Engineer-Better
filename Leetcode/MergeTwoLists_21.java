/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0), dummy = temp;
        
        if(l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else {
            ListNode first = l1, second = l2;
            while(first != null && second != null) {
                if(first.val < second.val) {
                    dummy.next = first;
                    first = first.next;
                }
                else {
                    dummy.next = second;
                    second = second.next;
                }
                dummy = dummy.next;
            }
            while(first != null) {
                 dummy.next = first;
                 first = first.next;
                dummy = dummy.next;
            }
            
            while(second != null) {
                dummy.next = second;
                second = second.next;
                dummy = dummy.next;
            }
        }
        return temp.next;
    }
}

/*
Approach: Check if any of them is null. If not null, compare values and sort them 
*/

//O(1)S:O(L1+l2)T