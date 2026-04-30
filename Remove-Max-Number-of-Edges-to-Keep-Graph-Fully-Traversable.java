1class Solution {
2    public int maxNumEdgesToRemove(int n, int[][] edges) {
3        int pa[]=new int[n+1];
4        int pb[]=new int[n+1];
5
6        for(int i=0;i<=n;i++) pa[i]=i;
7        for(int i=0;i<=n;i++) pb[i]=i;
8
9        Arrays.sort(edges,(a,b)->b[0]-a[0]);
10        int adde=0;
11        int c1=n;
12        int c2=n;
13        for(int i[]:edges){
14            int type=i[0];
15            int a=i[1];
16            int b=i[2];
17            if(type==3){
18                boolean add=false;
19                int paa=find(a,pa);
20                int pba=find(b,pa);
21                if(paa!=pba){
22                    union(a,b,pa);
23                    c1--;
24                    add=true;
25                }
26                int pab=find(a,pb);
27                int pbb=find(b,pb);
28                if(pab!=pba){
29                    union(a,b,pb);
30                    c2--;
31                    add=true;
32                }
33                if(add) adde++;
34            }else if(type==2){
35                int pba=find(a,pb);
36                int pbb=find(b,pb);
37                if(pba!=pbb){
38                    union(a,b,pb);
39                    c2--;
40                    adde++;
41                }
42            }else{
43                int paa=find(a,pa);
44                int pba=find(b,pa);
45                if(paa!=pba){
46                    union(a,b,pa);
47                    c1--;
48                    adde++;
49                }
50            } 
51
52        }
53        System.out.print(c1+" "+ c2);
54        if(c1==1 && c2==1){
55            return  edges.length-adde;
56        }
57        return -1;
58    }
59    public void union(int a,int b,int[] parent){
60        int pa=find(a,parent);
61        int pb=find(b,parent);
62        if(pa!=pb) parent[pa]=pb;
63    }
64    public int find(int a,int[] parent){
65        if(parent[a]==a) return a;
66        return parent[a]=find(parent[a],parent);
67    }
68}