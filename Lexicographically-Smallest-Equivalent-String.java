1class Solution {
2    public String smallestEquivalentString(String s1, String s2, String baseStr) {
3        char parent[] = new char[26];
4
5        for (int i = 0; i < 26; i++) {
6            parent[i] = (char)(i + 'a');
7        }
8
9        for (int i = 0; i < s1.length(); i++) {
10            Union(s1.charAt(i), s2.charAt(i), parent);
11        }
12
13        StringBuilder result = new StringBuilder();
14
15        for (char ch : baseStr.toCharArray()) {
16            result.append(find(ch, parent));
17        }
18
19        return result.toString();
20    }
21
22    public void Union(char a, char b, char parent[]) {
23        char pa = find(a, parent);
24        char pb = find(b, parent);
25
26        if (pa != pb) {
27            if (pa < pb) {
28                parent[pb - 'a'] = pa;
29            } else {
30                parent[pa - 'a'] = pb;
31            }
32        }
33    }
34
35    public char find(char a, char parent[]) {
36        if (parent[a - 'a'] == a) return a;
37        return parent[a - 'a'] = find(parent[a - 'a'], parent);
38    }
39}