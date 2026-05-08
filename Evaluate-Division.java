1class Solution {
2    class  Pair{
3        String node;
4        double val;
5        Pair(String s,double d){
6            node=s;
7            val=d;
8        }
9    }
10    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
11
12        HashMap<String,List<Pair>> adj= new HashMap<>();
13        for(int i=0;i<equations.size();i++){
14            String u=equations.get(i).get(0);
15            String v=equations.get(i).get(1);
16            double val=values[i];
17
18            adj.putIfAbsent(u,new ArrayList<>());
19            adj.putIfAbsent(v,new ArrayList<>());
20
21            adj.get(u).add(new Pair(v,val));
22            adj.get(v).add(new Pair(u,1.0/val));
23        }
24
25        double ans[]=new double[queries.size()];
26
27        for(int i=0;i<queries.size();i++){
28            String src=queries.get(i).get(0);
29            String dest=queries.get(i).get(1);
30
31            if(!adj.containsKey(src) || !adj.containsKey(dest)) ans[i]=-1.0;
32
33            else{
34                HashSet<String> visited=new HashSet<>();
35
36                ans[i]=dfs(adj,src,dest,visited,1.0);
37            }
38
39        }
40        return ans;
41
42    }
43    public double dfs(HashMap<String,List<Pair>> adj,String src,String dest, HashSet<String> visited,double product){
44        if(src.equals(dest)) return product;
45
46        visited.add(src);
47
48        for(Pair it:adj.get(src)){
49            if(!visited.contains(it.node)){
50                double res=dfs(adj,it.node,dest,visited,product*it.val);
51                if(res!=-1.0) return res;
52            }
53        }
54        return -1.0;
55    }
56}
57