1class Solution {
2    public int makeConnected(int n, int[][] connections) {
3        int nc=connections.length;
4        // 4 3 atleast chaiye 2 1 nhi chlege
5        if(nc<n-1) return -1;
6        int parent[]=new int[n];
7        for(int i=0;i<n;i++) parent[i]=i;
8        int components=n;
9        for(int i[]:connections){
10            if(find(i[0],parent)!=find(i[1],parent)){
11                Union(i[0],i[1],parent);
12                components--;
13            }
14        }
15        return components-1;
16    }
17    public void Union(int a,int b,int parent[]){
18        int pa=find(a,parent);
19        int pb=find(b,parent);
20
21        if(pa!=pb) parent[pa]=pb;
22    }
23    public int find(int a,int parent[]){
24        if(parent[a]==a) return a;
25        return parent[a]=find(parent[a],parent);
26    }
27}