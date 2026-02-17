1class Solution {
2    public int numSquares(int n) {
3        List<Integer> allSquares=new ArrayList<>();
4        int i=1;int num=1;
5        while(num<=n){
6            allSquares.add(num);
7            i++;
8            num=i*i;
9        }
10        int dp[]=new int[n+1];
11        int ans=calculate(allSquares,n,dp);
12        return ans;
13    }
14    public int calculate(List<Integer> allSquares,int n,int dp[]){
15        if(n==0) return 0;
16        if(n<0) return Integer.MAX_VALUE;
17        int min=Integer.MAX_VALUE;
18        if(dp[n]!=0) return dp[n];
19        for(int i=0;i<allSquares.size();i++){
20            int res=calculate(allSquares,n-allSquares.get(i),dp);
21            if(res!=Integer.MAX_VALUE){
22                min=Math.min(min,res+1);
23            }
24        }
25        return dp[n]=min;
26
27    }
28}