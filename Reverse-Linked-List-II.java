1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        ListNode dummy=new ListNode(0);
14        dummy.next=head;
15        int counter=0;
16        ListNode temp1=dummy;
17        ListNode temp2=head;
18        while(counter<left-1){
19            temp1=temp2;
20            temp2=temp2.next;
21            counter++;
22        }
23        //reverse logic
24        counter=0;
25        ListNode curr=temp2;
26        ListNode prev=temp1;
27        while(counter<(right-left+1)){
28            ListNode next=curr.next;
29            curr.next=prev;
30            prev=curr;
31            curr=next;
32            counter++;
33        }
34
35        temp1.next=prev;
36        temp2.next=curr;
37        return dummy.next;
38    }
39}