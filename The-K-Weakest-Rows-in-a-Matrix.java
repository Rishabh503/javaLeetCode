1class Solution {
2    public int[] kWeakestRows(int[][] mat, int k) {
3        // queue <soliders count , row index > 
4        // using minheap direclty 
5        PriorityQueue<int[]> pq=new PriorityQueue<>(
6            (a,b)->{
7                if(a[0]!=b[0]) return a[0]-b[0];
8                return a[1]-b[1];
9            }
10        );
11        for(int i=0;i<mat.length;i++){
12            int c=0;
13            for(int j=0;j<mat[i].length;j++){
14                if(mat[i][j]==1)c++;
15                else break;
16            }
17            pq.add(new int[]{c,i});
18        }
19        int ans[]=new int[k];
20        for(int i=0;i<k;i++){
21            ans[i]=pq.poll()[1];
22            }
23            return ans;
24    }
25}