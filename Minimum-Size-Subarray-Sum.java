class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int minl=nums.length+10;
        int sum=0;
        while(right<nums.length){
            sum+=nums[right];

            while(sum>=target){
                minl=Math.min(minl,right-left+1);
                sum=sum-nums[left];
                left++;
            }

            right++;
        }

        return minl==nums.length+10?0:minl;
    }
}