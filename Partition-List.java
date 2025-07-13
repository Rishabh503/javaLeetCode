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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0); ListNode smallTemp=small;
        ListNode big=new ListNode(0); ListNode bigTemp=big;
        ListNode temp=head;
        while(temp!=null){
            if(!(temp.val>=x)){
                smallTemp.next=temp;
                smallTemp=smallTemp.next;
            }else{
                bigTemp.next=temp;
                bigTemp=bigTemp.next;
            }
            temp=temp.next;
        }
        smallTemp.next=big.next;
        bigTemp.next=null;
        return small.next;
    }
}