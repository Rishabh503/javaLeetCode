class Solution {
    public int longestConsecutive(int[] nums) {
        // Step 1: Add all numbers to a HashSet
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        // Step 2: Loop through each number
        int maxi=0;
        for(int num:set){
                if(!set.contains(num-1)){
            int currNum=num;
            int curr=1;
            // check if the next elements exists if yes then till when  and count them too
     
               while(set.contains(currNum+1)){
                curr+=1;
                currNum+=1;
            }
         
         // update the maxxi 
            maxi=Math.max(maxi,curr);
        }}
        return maxi;
    }
}