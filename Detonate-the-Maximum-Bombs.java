1class Solution {
2    public int maximumDetonation(int[][] bombs) {
3        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<>();
4        int n=bombs.length;
5
6        for(int i=0;i<n;i++){
7            adj.put(i,new ArrayList<>());
8        }
9
10        for(int i=0;i<n;i++){
11            for(int j=0;j<n;j++){
12                if(i==j) continue;
13
14                if(lies(bombs[i][0],bombs[i][1],bombs[i][2],bombs[j][0],bombs[j][1])){
15                    adj.get(i).add(j);
16                }
17            }
18        }
19
20
21    int maxi=-1;
22        for(int i=0;i<n;i++){
23             boolean visited[]=new boolean[n];
24            int det=dfs(adj,i,visited);
25            maxi=Math.max(det,maxi);
26        }
27
28        return maxi;
29    }
30
31    public int dfs( HashMap<Integer,ArrayList<Integer>> adj,int curr,boolean visited[]){
32        visited[curr]=true;
33        int size=1;
34        for(int v:adj.get(curr)){
35            if(!visited[v]){
36                size+=dfs(adj,v,visited);
37            }
38        }
39        return size;
40    }
41
42    
43    public boolean lies(int x,int y,int r,int x1,int y1){
44        long dx=x-x1;
45        long dy=y-y1;
46        long dist=dx*dx+dy*dy;
47        long rs=(long)r*r;
48        return rs>=dist;
49    }
50}