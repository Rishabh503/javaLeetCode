class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        int high=nums.length-1;
        if(nums[0]>nums[1]) return 0;
        if(nums[high]>nums[high-1]) return high;

        int low=1;
        int mid=(low+high)/2;
        while(low<=high){
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            else if(nums[mid]<nums[mid+1]){
                    low=mid+1;
            }else{
                    high=mid-1;
            }
            mid=(low+high)/2;
        }
        return mid;
    }
}