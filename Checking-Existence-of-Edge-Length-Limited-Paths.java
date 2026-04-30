1class Solution{
2    public boolean[] distanceLimitedPathsExist(int n,int[][] edgeList,int[][] queries){
3        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
4        int[][] qn=new int[queries.length][4];
5        for(int i=0;i<queries.length;i++){
6            qn[i]=new int[]{queries[i][0],queries[i][1],queries[i][2],i};
7        }
8
9        Arrays.sort(qn,(a,b)->a[2]-b[2]);
10
11        boolean[] ans=new boolean[qn.length];
12        int[] parent=new int[n];
13
14        
15        for(int i=0;i<n;i++) parent[i]=i;
16        int j=0;
17        for(int i=0;i<qn.length;i++){
18            while(j<edgeList.length&&edgeList[j][2]<qn[i][2]){
19                union(edgeList[j][0],edgeList[j][1],parent);
20                j++;
21            }
22            int pa=find(qn[i][0],parent);
23            int pb=find(qn[i][1],parent);
24            ans[qn[i][3]]=pa==pb;
25        }
26        return ans;
27    }
28    public void union(int a,int b,int[] parent){
29        int pa=find(a,parent);
30        int pb=find(b,parent);
31        if(pa!=pb) parent[pa]=pb;
32    }
33    public int find(int a,int[] parent){
34        if(parent[a]==a) return a;
35        return parent[a]=find(parent[a],parent);
36    }
37}