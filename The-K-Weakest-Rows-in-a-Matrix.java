1class Solution {
2    public int[] kWeakestRows(int[][] mat, int k) {
3        // queue <soliders count , row index > 
4        // using maxheap  
5        PriorityQueue<int[]> pq=new PriorityQueue<>(
6            (a,b)->{
7                if(a[0]!=b[0]) return b[0]-a[0];
8                return b[1]-a[1];
9            }
10        );
11        // tc  O(n*(m+logn))
12        for(int i=0;i<mat.length;i++){
13            int c=0;
14            for(int j=0;j<mat[i].length;j++){
15                if(mat[i][j]==1)c++;
16                else break;
17            }
18            pq.add(new int[]{c,i});
19            if(pq.size()>k){
20                pq.poll();
21            }
22        }
23        int[] ans = new int[k];
24        for (int i = k - 1; i >= 0; i--) {
25            ans[i] = pq.poll()[1];
26        }
27
28        return ans;
29    }
30}