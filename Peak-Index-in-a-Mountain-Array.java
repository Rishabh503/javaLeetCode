class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int high=arr.length-1;
        int low=0;
        
        while(low<=high){
            int mid=(high+low)/2;
            if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }else{
                high=mid-1;
            }
      
        }
        return low;
    }
}