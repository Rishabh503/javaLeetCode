1class Solution {
2    public boolean carPooling(int[][] trips, int capacity) {
3        Map<Integer,Integer> map=new TreeMap<>();
4        for(int i[]:trips){
5            map.put(i[1],map.getOrDefault(i[1],0)+i[0]);
6            map.put(i[2],map.getOrDefault(i[2],0)- i[0]);
7        }
8        int bookings=0;
9         for(Map.Entry<Integer,Integer> entry:map.entrySet()){
10            bookings+=entry.getValue();
11            if(bookings>capacity) return false;
12         }
13         return true;
14    }
15}