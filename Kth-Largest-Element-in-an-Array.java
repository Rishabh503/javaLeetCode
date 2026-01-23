1class Solution {
2    public int findKthLargest(int[] arr, int k) {
3        PriorityQueue<Integer> pq=new PriorityQueue<>();
4        for(int i=0;i<k;i++){
5            pq.add(arr[i]);
6        }
7        for(int i=k;i<arr.length;i++){
8            if(pq.peek()<arr[i]){
9                pq.poll();
10                pq.add(arr[i]);
11            }
12        }
13        return pq.peek();
14    }
15}