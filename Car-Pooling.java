1class Solution {
2    public boolean carPooling(int[][] trips, int capacity) {
3        int buckets[]=new int[1001];
4        for(int i[]:trips){
5            buckets[i[1]]+=i[0];
6            buckets[i[2]]-=i[0];
7        }
8        int passengers=0;
9        for(int bucket:buckets){
10            passengers+=bucket;
11            if(passengers>capacity) return false;
12        }
13        return true;
14
15    }
16
17    public boolean carUsingLineSweep(int trips[][],int capacity){
18        Map<Integer,Integer> map=new TreeMap<>();
19        for(int i[]:trips){
20            map.put(i[1],map.getOrDefault(i[1],0)+i[0]);
21            map.put(i[2],map.getOrDefault(i[2],0)- i[0]);
22        }
23        int bookings=0;
24         for(Map.Entry<Integer,Integer> entry:map.entrySet()){
25            bookings+=entry.getValue();
26            if(bookings>capacity) return false;
27         }
28         return true;
29    }
30}
31