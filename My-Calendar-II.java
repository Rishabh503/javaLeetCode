1class MyCalendarTwo {
2        Map<Integer,Integer> map;
3    
4    public MyCalendarTwo() {
5        map=new TreeMap<Integer,Integer>();
6    }
7    
8    public boolean book(int startTime, int endTime) {
9        map.put(startTime,map.getOrDefault(startTime,0)+1);
10        map.put(endTime,map.getOrDefault(endTime,0)-1);
11
12        int bookings=0;
13        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
14            bookings+=entry.getValue();
15        
16        if(bookings>2){
17            map.put(startTime,map.getOrDefault(startTime,0)-1);
18            map.put(endTime,map.getOrDefault(endTime,0)+1);
19            return false;
20        }
21        }
22        return true;
23    }
24}
25
26/**
27 * Your MyCalendarTwo object will be instantiated and called as such:
28 * MyCalendarTwo obj = new MyCalendarTwo();
29 * boolean param_1 = obj.book(startTime,endTime);
30 */