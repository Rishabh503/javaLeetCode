class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(abs(map.get(nums[i]),i)<=k) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
    public int abs(int a,int b){
        if((a-b)>=0){
            return a-b;
        }
        return b-a;
    }
}