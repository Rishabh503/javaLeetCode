class Solution {
    public int[] searchRange(int[] nums, int target) {
        // find first and then last
        int ans[]={-1,-1};
        int low=0;
        int high=nums.length-1;
        int mid=(low+high)/2;
        while(low<=high){
            if(nums[mid]==target){
                ans[0]=mid;
                high=mid-1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
            mid=(low+high)/2;
        }
        high=nums.length-1;
        low=0;
        mid=(low+high)/2;
         while(low<=high){
            if(nums[mid]==target){
                ans[1]=mid;
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
            mid=(low+high)/2;
        }
        return ans;
    }
}