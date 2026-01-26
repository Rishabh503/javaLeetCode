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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        // recureivsley 
14        if(k==1) return head;
15        int count=0;
16        ListNode temp=head;
17        ListNode d=head;
18        while(count<k){
19            if(temp==null){
20                return head;
21            }
22            temp=temp.next;
23            count++;
24        }
25        // ListNode d=temp;
26        ListNode restList=reverseKGroup(temp,k);
27        temp=head;
28        count=0;
29        ListNode prev=null;
30        while(count<k){
31            ListNode next=temp.next;
32            temp.next=prev;
33            prev=temp;
34            temp=next;
35            count++;
36        }
37        // System.out.println("rest: "+restList.val); 
38        // System.out.println("d: "+d.val); 
39        d.next=restList;
40        return prev;
41    }
42}