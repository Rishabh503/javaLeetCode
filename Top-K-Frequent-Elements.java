class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //bucket sort lagyeyge because alone hashmap is faling
        // lets make the bucket and hasmap
        List<Integer>[] bucket=new List[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();

        // fill the elements 
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //fill the buckets

        // iterate over the hashmap right 
        for(int key:map.keySet()){
            // find the element 
            int element=map.get(key);
            //check if the bucket for it exists or not 
            if(bucket[element]==null){
                bucket[element]=new ArrayList<>();
            }
            // add the element 
            bucket[element].add(key);
        }
        // ans ke liye array n counter
       int result[]=new int[k];
       int counter=0;

       for(int i=bucket.length-1;i>=0 && counter<k;i--){
        // check krna pdega na bucket pe saman hai ya n ii 
        if(bucket[i]!=null){
            // bucket ek arraylist h uska saman hume result me dalna 
            // hai bascially agre ek frequeny k pass ek se jyada element hue to wo aise hi daldege 
            for(Integer j:bucket[i]){
                result[counter++]=j;
            }
        }
       }
        return result;

    }
}