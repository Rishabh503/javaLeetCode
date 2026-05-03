1class Solution {
2    public int sumOfPrimesInRange(int n) {
3        String s=Integer.toString(n);
4        StringBuilder r=new StringBuilder();
5        for(int i=s.length()-1;i>=0;i--){
6            r.append(s.charAt(i));
7        }
8        int rev=Integer.parseInt(r.toString());
9        int sum=0;
10        for(int i=Math.min(n,rev);i<=Math.max(n,rev);i++){
11            if(isPrime(i)) sum+=i;
12        }
13        return sum;
14    }
15    public boolean isPrime(int n){
16        if(n<=1) return false;
17        for(int i=2;i<=Math.sqrt(n);i++){
18            if(n%i==0) return false;
19        }
20        return true;
21    }
22}