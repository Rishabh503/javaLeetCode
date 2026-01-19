1class SummaryRanges {
2    TreeSet<Integer> list;
3    public SummaryRanges() {
4        list=new TreeSet<Integer>();
5    }
6    
7    public void addNum(int value) {
8        if(list.contains(value)) return; //to avoid duplicates
9        list.add(value);
10    }
11    
12    public int[][] getIntervals() {
13
14        if(list.size()==0){
15            return new int[][]{};
16        }
17        Integer left=null,right=null;
18
19        List<int[]> res=new ArrayList<>();
20
21        for(Integer val:list){
22            if(left==null && right==null){
23                // res.add(new int[]{})
24                left=val;
25                right=val;
26            }else if(val==right+1){
27                right=val;
28            }else{
29                res.add(new int[]{
30                    left,right
31                });
32                left=val;
33                right=val;
34            }
35        }
36        res.add(new int[]{
37            left,right
38        });
39
40        // make the desired ans/
41        int ans[][]=new int[res.size()][2];
42        for(int i=0;i<res.size();i++){
43            ans[i]=res.get(i);
44        }
45        return ans;
46    }
47}
48
49/**
50 * Your SummaryRanges object will be instantiated and called as such:
51 * SummaryRanges obj = new SummaryRanges();
52 * obj.addNum(value);
53 * int[][] param_2 = obj.getIntervals();
54 */