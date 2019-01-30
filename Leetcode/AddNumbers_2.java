/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
Approach: Add two numbers with digits stored as node values in linked list. As LSD is head of linked list, it is easy to sum up and check if there is a carry. Make sure to check that both of them are null, because one list may have more digits than the other. 
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = new ListNode(l1.val + l2.val), ptr = head;
        ListNode temp1 = l1.next, temp2 = l2.next;
        int reminder = head.val/10;
        if(head.val > 9)
            head.val = head.val - 10;
        
        while(temp1 != null || temp2 != null) {
            int x = (temp1 != null)?temp1.val:0;
            int y = (temp2 != null)?temp2.val:0;
            ListNode temp = new ListNode(x+y+reminder);
            if(temp.val > 9) {
                temp.val = temp.val % 10;
                reminder = 1;
            }
            else
                reminder = 0;
            ptr.next = temp;
            ptr = temp;
            
            if (temp1 != null) 
                temp1 = temp1.next;
            if (temp2 != null) 
                temp2 = temp2.next;
        }
        if(reminder == 1) {
            ListNode temp = new ListNode(1);
            ptr.next = temp;
        }
        return head;
    }
}