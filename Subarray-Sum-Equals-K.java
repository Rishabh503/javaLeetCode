class Solution {
    public int subarraySum(int[] nums, int k) {
        // we will map the sum and their pairs 
        // sum,pairs
        Map<Integer,Integer> map=new HashMap<>();

        // initally pair of 0 has to be added in case the k appears in the nums 
        map.put(0,1);

        int count=0;int sum=0;
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}