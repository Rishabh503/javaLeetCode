1class Task{
2    int freq;
3    int time;
4
5    public Task(int f,int t){
6        this.freq=f;
7        this.time=t;
8    }
9}
10
11class Solution {
12    public int leastInterval(char[] tasks, int n) {
13        int time=0;
14
15        PriorityQueue<Task> maxHeap=new PriorityQueue<>((a,b)->b.freq-a.freq);
16        Queue<Task> qt=new LinkedList<>();
17
18        int [] counts=new int [26];
19
20        for(char t:tasks){
21            counts[t-'A']= counts[t-'A']+1;
22        }
23        for(int c:counts){
24            if(c>0){
25                maxHeap.add(new Task(c,1));
26            }
27        }
28
29        while(!maxHeap.isEmpty() || !qt.isEmpty()){
30            time=time+1;
31            while(!qt.isEmpty() && qt.peek().time==time){
32                maxHeap.add(qt.poll());
33            }
34            if(!maxHeap.isEmpty()){
35                Task taskToExecute=maxHeap.poll();
36                taskToExecute.freq=taskToExecute.freq-1;
37                taskToExecute.time=time+(n+1);
38                if(taskToExecute.freq>0){
39                    qt.add(new Task(taskToExecute.freq,taskToExecute.time));
40                }
41            }
42        }
43return time ;
44    }
45}