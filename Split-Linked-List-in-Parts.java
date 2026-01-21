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
12    public ListNode[] splitListToParts(ListNode head, int k) {
13        ListNode ans[]=new ListNode[k];
14        ListNode curr=head;
15        int size=0;
16        while(curr!=null){
17            curr=curr.next;
18            size++;
19        }
20        int min=size/k;
21        int extra=size%k;
22        curr=head;
23         ListNode temp=curr;
24        for(int i=0;i<k;i++){
25            int j=1;
26            ans[i]=temp;
27            curr=temp;
28
29            int partsize = min + (extra > 0 ? 1 : 0);
30            if (extra > 0) extra--;
31
32            while(j<partsize && curr!=null && curr.next!=null){
33                curr=curr.next;
34                j++;
35            }
36            if(curr==null){
37                temp=null;
38                continue;
39            }
40            temp=curr.next;
41            curr.next=null;
42    
43        }
44
45        return ans;
46    }
47}