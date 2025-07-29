class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;int j=0;int maxi=0;int zeros=0;
        while(j<nums.length){
            // shrink
            if(nums[j]==0) zeros++;
            while(zeros>k){
               if(nums[i]==0) zeros--;
               i++;
            }
            // grow
            if(zeros<=k){
                maxi=Math.max(maxi,j-i+1);
            }
            j++;
        }
        return maxi;
    }
}