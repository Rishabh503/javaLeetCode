1class Solution {
2    public int minInsertions(String s1) {
3         String s2=reverse(s1);
4        System.out.println(s2);
5        int dp[][]=new int [s1.length()+1][s2.length()+1];
6        for(int i[]:dp) Arrays.fill(i,-1);
7        return s1.length()-LCS(s1,s2,0,0,dp);
8    }
9    public static int LCS(String s1,String s2,int i,int j,int dp[][]){
10        if(i==s1.length() ||j== s2.length()){
11            return 0;
12        }
13        if(dp[i][j]!=-1) return dp[i][j];
14        int ans=0;
15        if(s1.charAt(i)==s2.charAt(j)){
16            ans=1+LCS(s1,s2,i+1,j+1,dp);
17        }else{
18            int f=LCS(s1,s2,i+1,j,dp);
19            int s=LCS(s1,s2,i,j+1,dp);
20            ans=Math.max(f,s);
21        }
22        return dp[i][j]= ans;
23    }
24    public String reverse(String s){
25        int j=s.length()-1;
26        String ans="";
27        while(j>=0) {
28            ans=ans+s.charAt(j);
29            j--;
30        }
31        return ans;
32    }
33}