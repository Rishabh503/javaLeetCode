class Solution {
    public int search(int[] nums, int target) {
        int high=nums.length-1;
        int low=0;
        int mid=(high+low)/2;

        while(low<=high){
            if(nums[mid]==target) return mid;

         

            //right wala sorted
            else if(nums[mid]<=nums[high]){
                // value lies ther 
                if(nums[mid]<target && nums[high]>=target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
                
            }
            else{
                if(nums[mid]>target && nums[low]<=target){
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
                
            }
            mid=(low+high)/2;
        }
        return -1;
    }
}