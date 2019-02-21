/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        if(count == 1 && n == 1)
            return null;
        int num = count - n;
        if(num == 0)
            return head.next;
        temp = head;
        while(num > 1 && temp != null) {
            num--;
            temp = temp.next;
            System.out.println(temp.val+" "+num);
        }
        if(temp.next != null)
            temp.next = temp.next.next;
        
        return head;
    }
}

/*
Approach: O(N)T:O(1)S 
nth node from end means (size-n)th node from beginning. So, count them in one pass and then delete it in next pass. 
Two pass solution above
*/

