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
12    public void reorderList(ListNode head) {
13        ListNode slow=head;
14        ListNode fast=slow;
15        while(fast!=null && fast.next!=null){
16            slow=slow.next;
17            fast=fast.next.next;
18        }
19        // reverese
20        ListNode current=slow;
21        ListNode prev=null;
22        while(current!=null){
23            ListNode next=current.next;
24            current.next=prev;
25            prev= current;
26             current=next;
27        }
28
29        ListNode l1=head;
30        ListNode l2=prev;
31
32        while(l2.next!=null){
33            ListNode temp1=l1.next;
34            ListNode temp2=l2.next;
35            l1.next=l2;
36            l2.next=temp1;
37            l1=temp1;
38            l2=temp2;
39        }
40    }
41
42}