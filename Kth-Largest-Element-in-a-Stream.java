1class KthLargest {
2    //intilize one ds for this
3     PriorityQueue<Integer> pq;
4     int k;
5    public KthLargest(int k, int[] nums) {
6       this.k = k;
7
8        pq=new PriorityQueue<Integer>();
9        for(int i:nums){
10            pq.add(i);
11            if(pq.size()>k){
12                pq.poll();
13            }
14        }
15    }
16    
17    public int add(int val) {
18        if(pq.size()<k){
19            pq.add(val);
20            return pq.peek();
21        }
22        pq.add(val);
23        pq.poll();
24        return pq.peek();
25        }
26}
27
28/**
29 * Your KthLargest object will be instantiated and called as such:
30 * KthLargest obj = new KthLargest(k, nums);
31 * int param_1 = obj.add(val);
32 */