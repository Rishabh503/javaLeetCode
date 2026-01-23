1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        //bucket sort lagyeyge because alone hashmap is faling
4        // lets make the bucket and hasmap
5        List<Integer>[] bucket=new List[nums.length+1];
6        Map<Integer,Integer> map=new HashMap<>();
7
8        // fill the elements 
9        for(int num:nums){
10            map.put(num,map.getOrDefault(num,0)+1);
11        }
12
13        //fill the buckets
14
15        // iterate over the hashmap right 
16        for(int key:map.keySet()){
17            // find the element 
18            int element=map.get(key);
19            //check if the bucket for it exists or not 
20            if(bucket[element]==null){
21                bucket[element]=new ArrayList<>();
22            }
23            // add the element 
24            bucket[element].add(key);
25        }
26        // ans ke liye array n counter
27       int result[]=new int[k];
28       int counter=0;
29
30       for(int i=bucket.length-1;i>=0 && counter<k;i--){
31        // check krna pdega na bucket pe saman hai ya n ii 
32        if(bucket[i]!=null){
33            // bucket ek arraylist h uska saman hume result me dalna 
34            // hai bascially agre ek frequeny k pass ek se jyada element hue to wo aise hi daldege 
35            for(Integer j:bucket[i]){
36                result[counter++]=j;
37            }
38        }
39       }
40        return result;
41
42    }
43}