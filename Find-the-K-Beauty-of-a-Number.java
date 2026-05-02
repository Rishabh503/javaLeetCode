1class Solution {
2    public int divisorSubstrings(int num, int k) {
3        String s=Integer.toString(num);
4        int n=s.length();
5        int ans=0;
6        for(int i=0;i<n-k+1;i++){
7            String t=s.substring(i,k+i);
8            int curr=Integer.parseInt(t);
9            if(curr==0) continue;
10            if(num%curr==0) ans++;
11        }
12        return ans;
13    }
14}