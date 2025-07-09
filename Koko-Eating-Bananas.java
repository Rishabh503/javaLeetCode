class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=getMax(piles);
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            long total=totalHours(piles,mid);
            if(total<=h){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public int getMax(int arr[]){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(ans<arr[i]){
                ans=arr[i];
            }
        }
        return ans;
    }
    public long totalHours(int arr[],int divisor){
        long totalHours=0;
        for(int i=0;i<arr.length;i++){
            totalHours=totalHours+ceilDivide(arr[i],divisor);
        }
        return totalHours;
    }
     public static int ceilDivide(int numerator, int denominator) {
        return (numerator + denominator - 1) / denominator;
    }
}