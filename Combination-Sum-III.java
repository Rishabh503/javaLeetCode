class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Print4(k, n, 1, ans, ll);
        return ans;
    }

    public static void Print4(int k, int target, int start, List<List<Integer>> ans, List<Integer> ll) {
        if (ll.size() == k && target == 0) {
            ans.add(new ArrayList<>(ll));
            return;
        }
        if (ll.size() > k || target < 0) return;

        for (int i = start; i <= 9; i++) {
            ll.add(i);
            Print4(k, target - i, i + 1, ans, ll);
            ll.remove(ll.size() - 1);
        }
    }
}
