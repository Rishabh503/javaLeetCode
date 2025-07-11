/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // to track the old address 
        ListNode prev=null;
        // pointer to traverse 
        ListNode current=head;
        while(current!=null){
            ListNode ahead=current.next;
            // ab muje intial me change krne hai so wo current se hoga and usme uske ek pehle ka hi to dalna hai 
            current.next=prev;
            // prev ko age bdhana hai 
            prev=current;
            // because traverse krna hai 
            current=ahead;
        }
        return prev;
    }
}