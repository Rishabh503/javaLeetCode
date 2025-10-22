class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int length=0;
        for(int i:set){
           if(!set.contains(i-1)) {int currNum=i;
            int curr=1;
            while(set.contains(currNum+1)){
                currNum++;
                curr++;
            }
            length=Math.max(curr,length);}

        }
        return length;
    }
}