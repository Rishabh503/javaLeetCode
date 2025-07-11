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
    public ListNode doubleIt(ListNode head) {
     ListNode curr2=reverseList(head);
     ListNode curr=curr2;
     ListNode prev=null;
     int carry=0;
    while(curr!=null ){
        int dval=curr.val*2+carry;
        if(dval>=10){
            carry=1;
        }else{
            carry=0;
        }
        curr.val=dval%10;
        prev=curr;
        curr=curr.next;
    }
    if(carry==1) {
        prev.next=new  ListNode(1);
        }
    return reverseList(curr2);
    }


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