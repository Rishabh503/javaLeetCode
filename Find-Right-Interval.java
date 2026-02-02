1class Solution {
2    public int[] findRightInterval(int[][] intervals) {
3        int ans[]=new int[intervals.length];
4        Arrays.fill(ans,-1);
5        PriorityQueue<int[]> startHeap=new  PriorityQueue<>((a,b)->a[0]-b[0]);
6        PriorityQueue<int[]> endHeap=new  PriorityQueue<>((a,b)->a[0]-b[0]);
7        for(int i=0;i<intervals.length;i++){
8            startHeap.add(new int[]{intervals[i][0],i});
9            endHeap.add(new int[]{intervals[i][1],i});
10        }
11        while(!startHeap.isEmpty() && !endHeap.isEmpty()){
12            int[] startEle=startHeap.peek();
13            if(startEle[0]>=endHeap.peek()[0]){
14                ans[endHeap.peek()[1]]=startEle[1];
15                endHeap.poll();
16            }else{
17                startHeap.poll();
18            }
19        }
20        return ans;
21    }
22}