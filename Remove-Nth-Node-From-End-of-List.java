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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode node3=get(head,5);
         int size=size(head);
           if (n == size) return head.next;
        int f=size-n+1;
        ListNode nth=get(head,f);
        ListNode noth=get(head,f-1);
        noth.next=nth.next;
        return head;
    }
    public ListNode get(ListNode head,int k){
        ListNode curr=head;
        int num=1;
        while(k!=num && curr!=null){
            curr=curr.next;num++;
        }
        return curr;
    }

    public int size(ListNode head){
        ListNode curr=head;
        int size=0;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        return size;
    }
   
}