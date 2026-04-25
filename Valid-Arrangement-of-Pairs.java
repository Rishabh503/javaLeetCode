1class Solution {
2      public int[][] validArrangement(int[][] pairs) {
3        // Step-1: Build adjacency list - Graph
4        Map<Integer, List<Integer>> adj = new HashMap<>();
5        
6        // Build indegree and outdegree
7        Map<Integer, Integer> indegree = new HashMap<>();
8        Map<Integer, Integer> outdegree = new HashMap<>();
9
10        // Build the graph and calculate indegree/outdegree
11        for (int[] edge : pairs) {
12            int u = edge[0];
13            int v = edge[1];
14            
15            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
16            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
17            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
18        }
19
20        // Step-2: Find the start node of the Euler Path
21        int startNode = pairs[0][0];
22        for (int node : adj.keySet()) {
23            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
24                startNode = node;
25                break;
26            }
27        }
28
29        // Step-3: Perform DFS to find the Euler Path
30        List<Integer> eulerPath = new ArrayList<>();
31        Stack<Integer> stack = new Stack<>();
32        stack.push(startNode);
33
34        while (!stack.isEmpty()) {
35            int curr = stack.peek();
36            if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
37                int neighbor = adj.get(curr).remove(adj.get(curr).size() - 1);
38                stack.push(neighbor);
39            } else {
40                eulerPath.add(curr);
41                stack.pop();
42            }
43        }
44
45        // Step-4: Build the result from the Euler path
46        Collections.reverse(eulerPath);
47        int[][] result = new int[eulerPath.size() - 1][2];
48        for (int i = 0; i < eulerPath.size() - 1; i++) {
49            result[i][0] = eulerPath.get(i);
50            result[i][1] = eulerPath.get(i + 1);
51        }
52
53        return result;
54    }
55}