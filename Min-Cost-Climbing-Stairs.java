class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(min(cost,0,dp),min(cost,1,dp));
    }
    public static int min(int arr[],int i,int dp[]){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int a=min(arr,i+1,dp);
        int b=min(arr,i+2,dp);

        return dp[i]=arr[i]+Math.min(a,b);
    }
}