/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 
1. fast and slow. slow would be in middle when fast reaches end
2. If fast is null, even. Else, odd => if odd, slow = slow.next
3. Reverse first half till slow-1
4. Compare both linkedlists 
**/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) 
            return true;
        ListNode fast = head, slow = head;
        boolean even = false;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null) 
            even = true;
        ListNode head2 = reverseList(head,slow);
        fast = head2;
        
        if(!even) head = slow.next;
        else head = slow;
        
        if(head == null && head2 == null)
            return true;
        else if(head == null || head2 == null)
            return false;
        else {
            while(head != null && head2 != null) {
                if(head.val == head2.val) {
                    head = head.next;
                    head2 = head2.next;
                }
                else
                    return false;
            }
            return true;
        }
    }
    
    public ListNode reverseList(ListNode start, ListNode end) {
        if(start == null || start.next == null)
            return start;
        ListNode prev = null, curr = start, next = curr;
        while(curr != end && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}