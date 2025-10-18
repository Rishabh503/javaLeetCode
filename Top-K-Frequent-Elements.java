class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        List<Integer>[] bucket=new List[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

  
        for(int key:map.keySet()){
          
            int element=map.get(key);
           
            if(bucket[element]==null){
                bucket[element]=new ArrayList<>();
            }
          
            bucket[element].add(key);
        }
      
       int result[]=new int[k];
       int counter=0;

       for(int i=bucket.length-1;i>=0 && counter<k;i--){
     
        if(bucket[i]!=null){
         
            for(Integer j:bucket[i]){
                result[counter++]=j;
            }
        }
       }
        return result;

    }
}