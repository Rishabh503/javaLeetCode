1class Solution {
2
3    public int leastInterval(char[] tasks, int n) {
4        HashMap<Character, Integer> map = new HashMap<>();
5        int maxfreq = -1;
6        for (int i = 0; i < tasks.length; i++) {
7            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
8            maxfreq = Math.max(map.get(tasks[i]), maxfreq);
9        }
10        int countMax = 0;
11        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
12            if (maxfreq == entry.getValue()) {
13                countMax++;
14            }
15        }
16
17        int time = (maxfreq - 1) * (n + 1) + countMax;
18
19        return Math.max(time, tasks.length);
20    }
21}