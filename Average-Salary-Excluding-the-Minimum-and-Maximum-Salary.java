1class Solution {
2    public double average(int[] salary) {
3        double maxi=Double.MIN_VALUE;
4        double mini=Double.MAX_VALUE;
5        for(double i:salary){
6            maxi=Math.max(maxi,i);
7            mini=Math.min(mini,i);
8        }
9        int len=salary.length;
10        if(maxi==mini) len--;
11        else len=len-2;
12        double sum=0;
13        for(double val:salary){
14            sum+=val;
15        }
16        sum=sum-maxi-mini;
17        return sum/len;
18    }
19}