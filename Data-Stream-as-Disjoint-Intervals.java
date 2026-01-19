1class SummaryRanges {
2    List<Integer> list;
3    public SummaryRanges() {
4        list=new ArrayList<Integer>();
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
17        //sort the list 
18        Collections.sort(list);
19
20        // take 2 iterators/pointer 
21        Integer left=null,right=null;
22
23        List<int[]> res=new ArrayList<>();
24
25        for(int i=0;i<list.size();i++){
26            if(left==null && right==null){
27                // res.add(new int[]{})
28                left=list.get(i);
29                right=list.get(i);
30            }else if(list.get(i)==right+1){
31                right=list.get(i);
32            }else{
33                res.add(new int[]{
34                    left,right
35                });
36                left=list.get(i);
37                right=list.get(i);
38            }
39        }
40        res.add(new int[]{
41            left,right
42        });
43
44        // make the desired ans/
45        int ans[][]=new int[res.size()][2];
46        for(int i=0;i<res.size();i++){
47            ans[i]=res.get(i);
48        }
49        return ans;
50    }
51}
52
53/**
54 * Your SummaryRanges object will be instantiated and called as such:
55 * SummaryRanges obj = new SummaryRanges();
56 * obj.addNum(value);
57 * int[][] param_2 = obj.getIntervals();
58 */