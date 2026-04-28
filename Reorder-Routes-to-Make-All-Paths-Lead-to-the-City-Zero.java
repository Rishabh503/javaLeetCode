1class Solution {
2    class Pair{
3        int node,type;
4        Pair(int n,int t){
5            node=n;
6            type=t;
7        }
8    }
9    public int minReorder(int n, int[][] edges) {
10        HashMap<Integer,ArrayList<Pair>> adj=new HashMap<>();
11        for(int i=0;i<n;i++){
12            adj.put(i,new ArrayList<>());
13
14        }
15
16        for(int i[]:edges){
17            int u=i[0];
18            int v=i[1];
19            adj.get(u).add(new Pair(v,1));
20            adj.get(v).add(new Pair(u,0));
21        }
22        int flips[]={0};
23        boolean visited[]=new boolean[n];
24        dfs(adj,0,visited,flips);
25        return flips[0];
26    }
27
28    public void dfs( HashMap<Integer,ArrayList<Pair>> adj,int curr,boolean visited[],int flips[]){
29        if(visited[curr]) return ;
30        visited[curr]=true;
31
32         for(Pair it:adj.get(curr)){
33            if(!visited[it.node]){
34                if(it.type==1) flips[0]++;
35                dfs(adj,it.node,visited,flips);
36            }
37         }
38    }
39}