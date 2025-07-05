import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  // Sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // Early stop (sorted array)

            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, curr, result); // i+1 because element can be used only once
            curr.remove(curr.size() - 1); // backtrack
        }
    }
}
