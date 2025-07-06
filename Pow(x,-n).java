class Solution {
    public double myPow(double x, int n) {
        long ans=n;
        if(n<0) return fastPower(1/x,(-ans));
        return fastPower(x,ans);
    }

    public double fastPower(double x,long n){
        if(n==0) return 1;
        double half=fastPower(x,n/2);
        if(n%2==0) return half*half;
        else return half*half*x;
    }
}